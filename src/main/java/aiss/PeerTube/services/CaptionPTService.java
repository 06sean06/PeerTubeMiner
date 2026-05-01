package aiss.PeerTube.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import aiss.PeerTube.model.modelPT.caption.CaptionPT;
import aiss.PeerTube.model.modelPT.caption.CaptionPTResponse;
import aiss.PeerTube.model.modelVM.CaptionVM;
import aiss.PeerTube.transformer.Transformer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@Service
public class CaptionPTService {

    // Si no se importa así te da error porque no tienen manera de comunicarse.
    @Autowired
    RestTemplate restTemplate;

    @Value("${peertube.url}")
    private String url; //https://peertube3.cpy.re/api/v1

    @Autowired
    Transformer transformer;

    @Value("${videominer.url}")
    private String urlvm; //http://localhost:8080/VideoMiner

    // GET https://peertube3.cpy.re/api/v1/videos/58UdeJ7NayzNSScpTE3YRa/captions
    public List<CaptionPT> findAllCaptionsOfVid(String idVideo) {
        String uri = url + "/videos/" + idVideo + "/captions";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);
        try {
        @SuppressWarnings("null")
        ResponseEntity<CaptionPTResponse> response = restTemplate.exchange(uri, HttpMethod.GET, request, CaptionPTResponse.class);
        CaptionPTResponse body = response.getBody();
        return (body != null) ? body.getData() : Collections.emptyList();
    } catch (HttpClientErrorException.NotFound e) {
        return null; 
    } catch (Exception e) {
        return Collections.emptyList();
    }
}
        
    

    //POST CAPTION http://localhost:8080/VideoMiner/captions
    public CaptionVM createCaption(CaptionPT captionPT) {
        // El subtítulo va a subirse con un post a VideoMiner. 
        // Recibimos un subtítulo con formato de PeerTube y lo cambiamos a VideoMiner.
        String uri = urlvm + "/captions";
        CaptionVM transformed = transformer.transformCaption(captionPT);
        // A continuación lo subimos con POST a la uri indicada. 
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<CaptionVM> request = new HttpEntity<>(transformed, headers);
        @SuppressWarnings("null")
        ResponseEntity<CaptionVM> response = restTemplate.exchange(uri, HttpMethod.POST, request, CaptionVM.class);
        CaptionVM caption  = response.getBody();
        if (caption == null ) {
            return null;
        }
        return caption;
    }

}
