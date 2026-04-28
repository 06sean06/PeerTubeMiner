package aiss.PeerTube.controllerPT;

import aiss.PeerTube.exception.CommentNotFoundException;
import aiss.PeerTube.model.modelPT.comment.CommentBasePT;
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

    // GET http://localhost:8080/PeerTube/comments/{id}
    @GetMapping("/{videoId}/{threadId}")
    public CommentBasePT getCommentById(@PathVariable String videoId, @PathVariable String threadId) throws CommentNotFoundException{
        CommentBasePT comment = commentService.getSpecificComment(videoId, threadId);
        return comment;
    }
}