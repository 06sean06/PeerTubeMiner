package aiss.PeerTube.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aiss.PeerTube.model.modelPT.comment.CommentBasePT;
import aiss.PeerTube.model.modelPT.comment.CommentPTResponse;
import aiss.PeerTube.model.modelPT.comment.CommentThreadPT;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CommentPTServiceTest {
    
    @Autowired
    CommentPTService commentPTService;

    @Test
@DisplayName("Comentarios de un video")
void testFindAllCommentsByVideo() {
    String videoId = "5JoZUZzbUdpNqGXpd5QJ5T";
    CommentPTResponse response = commentPTService.getCommentsByVideo(videoId);
    CommentBasePT first = response.getData().get(0);

    assertNotNull(response, "La respuesta no debe ser null");
    assertNotNull(response.getData(), "La lista de comentarios no debe ser null");

    assertEquals(4, response.getData().size(), "Debe haber 4 comentarios");
    assertEquals(88985, first.getId());
    assertEquals("<p>This is by far the best and most cinematic one from blenderstudio.</p>\n",
        first.getText());
    assertEquals("Helkriz", first.getAccount().getName());
    }

    @Test
    @DisplayName("Obtener un comentario en específico")
    void testFindSpecificComment() {
        String videoId = "5JoZUZzbUdpNqGXpd5QJ5T";
        String threadId = "88985";
        CommentThreadPT thread = commentPTService.getSpecificComment(videoId, threadId);
        CommentBasePT comment = thread.getComment();

        assertNotNull(thread);
        assertNotNull(thread.getComment());

        assertEquals(88985, comment.getId());
        assertEquals("<p>This is by far the best and most cinematic one from blenderstudio.</p>\n",
        comment.getText());
        assertEquals("Helkriz", comment.getAccount().getName());
}


}
    

