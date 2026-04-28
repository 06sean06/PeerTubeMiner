package aiss.PeerTube.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import aiss.PeerTube.modelPT.video.VideoPT;
import aiss.PeerTube.modelPT.video.VideoPTResponse;

@Service
public class VideoPTService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${peertube.url}")
    private String url;

    // GET https://peertube3.cpy.re/api/v1/videos
    public List<VideoPT> findAllVideos() {
        String uri = url + "/videos"; 
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<VideoPT> request = new HttpEntity<>(headers);
        @SuppressWarnings("null") // Lo he añadido porque VSCode cree que HttpMethod.GET es null, pero no lo es, es un enum.
        ResponseEntity<VideoPTResponse> response = restTemplate.exchange(uri, HttpMethod.GET, request, VideoPTResponse.class);
        VideoPTResponse body = response.getBody();
        if (body == null || body.getData() == null) {
            return List.of();
        }
        return body.getData();
    }

    //GET https://peertube3.cpy.re/api/v1/videos/5JoZUZzbUdpNqGXpd5QJ5T
    public VideoPT findVideoById(String idVideo) {
        String uri = url + "/videos/" + idVideo;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<VideoPT> request = new HttpEntity<>(headers);
        @SuppressWarnings("null") // Lo he añadido porque VSCode cree que HttpMethod.GET es null, pero no lo es, es un enum.
        ResponseEntity<VideoPT> response = restTemplate.exchange(uri, HttpMethod.GET, request, VideoPT.class);
        return response.getBody();
    }
}
