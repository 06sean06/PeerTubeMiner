
package aiss.PeerTube.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import aiss.PeerTube.model.modelPT.comment.CommentPTResponse;
import aiss.PeerTube.model.modelPT.comment.CommentThreadPT;



@Service
public class CommentPTService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${peertube.url}")
    private String url;

    // Obtener los comentarios de un video 
    // GET https://peertube3.cpy.re/api/v1/videos/{id}/comment-threads
    @SuppressWarnings("null")
    public CommentPTResponse getCommentsByVideo(String videoId) {
        String uri = url + "/videos/" + videoId + "/comment-threads";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<CommentPTResponse> response = restTemplate.exchange(uri, HttpMethod.GET, request, CommentPTResponse.class);
        CommentPTResponse body = response.getBody();
        if (body == null || body.getData() == null) {
            return null;
        }
        return body;
    }

    // Dado un idVideo y un idComment, te devuelve el comentario de ese video en específico. 
    // GET https://peertube3.cpy.re/api/v1/videos/{id}/comment-threads/{threadId}
    public CommentThreadPT getSpecificComment(String videoId, String threadId) {
        String uri = url + "/videos/" + videoId + "/comment-threads/" + threadId;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Void> request = new HttpEntity<>(headers);

        try {    
        ResponseEntity<CommentThreadPT> response = restTemplate.exchange(uri, HttpMethod.GET, request, CommentThreadPT.class);
        return response.getBody();
    } catch (org.springframework.web.client.HttpClientErrorException.NotFound e) {     // captura de error 
        return null;
    } catch (Exception e) {
        return null;
    }
    }

}