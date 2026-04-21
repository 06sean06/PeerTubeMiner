package aiss.PeerTube.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import aiss.PeerTube.modelPT.caption.CaptionPT;
import aiss.PeerTube.modelPT.caption.CaptionPTResponse;

@Service
public class CaptionPTService {

    // Si no se importa así te da error porque no tienen manera de comunicarse.
    @Autowired
    RestTemplate restTemplate;

    @Value("${peertube.url}")
    private String url; //https://peertube3.cpy.re/api/v1

    // GET https://peertube3.cpy.re/api/v1/videos/58UdeJ7NayzNSScpTE3YRa/captions
    public List<CaptionPT> findAllCaptionsOfVid(String idVideo) {
        String uri = url + "/videos/" + idVideo + "/captions";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<CaptionPTResponse> response = restTemplate.exchange(uri, HttpMethod.GET, request, CaptionPTResponse.class);
        // Puesto que puede que el vídeo no tenga ningún caption, el response puede ser null, por lo que se devuelve una lista vacía.
        return response.getBody().getData();
    }
}
