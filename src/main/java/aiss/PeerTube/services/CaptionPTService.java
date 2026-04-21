package aiss.PeerTube.services;

import java.util.ArrayList;
import java.util.Arrays;
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

@Service
public class CaptionPTService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${peertube.token}")
    private String token;

    // Encuentra todos los subtítulos de un video en concreto
    // GET https://peertube3.cpy.re/api/v1/videos/58UdeJ7NayzNSScpTE3YRa/captions
    public List<CaptionPT> findAllCaptionsOfVid(String idVideo) {
        String uri = "https://peertube3.cpy.re/api/v1/videos/" + idVideo + "/captions";
        // No es necesario acceder con el token (no tenemos token)
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<CaptionPT[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<CaptionPT[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, CaptionPT[].class);
        // Lo pasamos a List<CaptionPT>:
        List<CaptionPT> allCaptions = new ArrayList<>();
        allCaptions.addAll(Arrays.asList(response.getBody()));
        return allCaptions;
    }

}
