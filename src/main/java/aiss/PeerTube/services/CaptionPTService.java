package aiss.PeerTube.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import aiss.PeerTube.model.caption.CaptionPT;
import aiss.PeerTube.model.caption.CaptionPTResponse;

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

    // GET https://peertube3.cpy.re/api/v1/videos/58UdeJ7NayzNSScpTE3YRa/captions
    public List<CaptionPT> findAllCaptionsOfVid(String idVideo) {
        String uri = url + "/videos/" + idVideo + "/captions";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);
        @SuppressWarnings("null") // Lo he añadido porque VSCode cree que HttpMethod.GET es null, pero no lo es, es un enum.
        ResponseEntity<CaptionPTResponse> response = restTemplate.exchange(uri, HttpMethod.GET, request, CaptionPTResponse.class);
        CaptionPTResponse body = response.getBody();
        if (body == null || body.getData() == null) {
            return List.of();
        }
        return body.getData();
    }
}
