package aiss.PeerTube.services;

import aiss.PeerTube.modelPT.comment.CommentBasePT;
import aiss.PeerTube.modelPT.comment.CommentThreadPT;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CommentPTServiceTest {
    
    @Autowired
    CommentPTService commentPTService;

    @Test
    @DisplayName("Comentarios de un video")
    void testFindAllCommentsByVideo() {
        String videoId = "71178";
        List<CommentThreadPT> threads = commentPTService.getCommentsByVideo(videoId);
    
    }

    @Test
    @DisplayName("Obtener un comentario en específico")
    void testFindSpecificComment() {
        String videoId = "71178";
        String threadId = "89306";
        CommentBasePT comment = commentPTService.getSpecificComment(videoId, threadId);
        
    }

    @Test
    @DisplayName("Obtener todos los comentarios de la instancia")
    void testFindAllInstanceComments() {
        List<CommentBasePT> allComments = commentPTService.getAllInstanceComments();
    }
}
    

