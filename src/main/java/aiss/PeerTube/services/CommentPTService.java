package aiss.PeerTube.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import aiss.PeerTube.model.modelPT.comment.CommentBasePT;
import aiss.PeerTube.model.modelPT.comment.CommentPTResponse;
import aiss.PeerTube.model.modelPT.comment.CommentThreadPT;

import java.util.List;

@Service
public class CommentPTService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${peertube.url}")
    private String url;

    // GET https://peertube3.cpy.re/api/v1/videos/{id}/comment-threads
    public List<CommentThreadPT> getCommentsByVideo(String videoId) {
        String uri = url + "/videos/" + videoId + "/comment-threads";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);
        @SuppressWarnings("null")
        ResponseEntity<CommentPTResponse> response = restTemplate.exchange(uri, HttpMethod.GET, request, CommentPTResponse.class);
        
        CommentPTResponse body = response.getBody();
        if (body == null || body.getData() == null) {
            return List.of(); // Devuelve lista vacía si no hay nada, como en tu imagen
        }
        return body.getData();
    }

    // GET https://peertube3.cpy.re/api/v1/videos/{id}/comment-threads/{threadId}
    public CommentBasePT getSpecificComment(String videoId, String threadId) {
        String uri = url + "/videos/" + videoId + "/comment-threads/" + threadId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);

        @SuppressWarnings("null")
        ResponseEntity<CommentBasePT> response = restTemplate.exchange(uri, HttpMethod.GET, request, CommentBasePT.class);
        
        return response.getBody();
    }
    
    // GET https://peertube3.cpy.re/api/v1/videos/comments
    public List<CommentBasePT> getAllInstanceComments() {
        String uri = url + "/videos/comments";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);

        @SuppressWarnings("null")
        ResponseEntity<CommentPTResponse> response = restTemplate.exchange(uri, HttpMethod.GET, request, CommentPTResponse.class);
        
        CommentPTResponse body = response.getBody();
        if (body == null || body.getDataBase() == null) {
            return List.of();
        }
        return body.getDataBase();
    }
}
