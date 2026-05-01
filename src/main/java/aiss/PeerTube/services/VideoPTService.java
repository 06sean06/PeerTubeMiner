package aiss.PeerTube.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import aiss.PeerTube.model.modelPT.video.VideoPT;
import aiss.PeerTube.model.modelPT.video.VideoPTResponse;
import aiss.PeerTube.model.modelVM.VideoVM;
import aiss.PeerTube.transformer.Transformer;

@Service
public class VideoPTService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${peertube.url}")
    private String url;

    @Autowired
    Transformer transformer;

    @Value("${videominer.url}")
    private String urlvm; //http://localhost:8080/VideoMiner

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
        try{
        @SuppressWarnings("null") // Lo he añadido porque VSCode cree que HttpMethod.GET es null, pero no lo es, es un enum.
        ResponseEntity<VideoPT> response = restTemplate.exchange(uri, HttpMethod.GET, request, VideoPT.class);
        return response.getBody();
    } catch (HttpClientErrorException.NotFound e) {    
        return null;
    } catch (Exception e) {
        return null;
    }
    }

    //POST VIDEO http://localhost:8080/VideoMiner/videos
    public VideoVM createVideo(VideoPT videoPT) {
        String uri = urlvm + "/videos";
        VideoVM transformed = transformer.transformVideo(videoPT);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<VideoVM> request = new HttpEntity<>(transformed, headers);
        @SuppressWarnings("null")
        ResponseEntity<VideoVM> response = restTemplate.exchange(uri, HttpMethod.POST, request, VideoVM.class);
        VideoVM video  = response.getBody();
        if (video == null ) {
            return null;
        }
        return video;
    }

}
