package aiss.PeerTube.controllerPT;

import aiss.PeerTube.exception.CommentNotFoundException;
import aiss.PeerTube.model.modelPT.comment.CommentBasePT;
import aiss.PeerTube.model.modelPT.comment.CommentThreadPT;
import aiss.PeerTube.services.CommentPTService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("PeerTube/comments")
public class CommentPTController {
    private final CommentPTService commentService;

    public CommentPTController(CommentPTService commentService){
        this.commentService = commentService;
    }

    // GET http://localhost:8080/PeerTube/comments
    @GetMapping
    public List<CommentBasePT> getComment(){
        return commentService.getAllInstanceComments();
    }

    // GET http://localhost:8080/PeerTube/videos/{videoId}/comments
    @GetMapping("/videos/{videoId}/comments")
    public List<CommentThreadPT> getCommentById(@PathVariable String videoId, @PathVariable String threadId) throws CommentNotFoundException{
        return commentService.getCommentsByVideo(videoId);
    }
}