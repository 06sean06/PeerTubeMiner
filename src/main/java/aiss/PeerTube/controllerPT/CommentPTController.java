package aiss.PeerTube.controllerPT;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aiss.PeerTube.model.modelPT.comment.CommentPTResponse;
import aiss.PeerTube.model.modelPT.comment.CommentThreadPT;
import aiss.PeerTube.repositoryPT.CommentPTRepository;

@RestController
@RequestMapping("PeerTube/comments")
public class CommentPTController {

    private final CommentPTRepository commentRepository;

    public CommentPTController(CommentPTRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // GET http://localhost:8080/PeerTube/comments/{videoId}
    @GetMapping("/{videoId}")
    public CommentPTResponse getCommentsByVideo(@PathVariable String videoId) {
        return commentRepository.findAllCommentsByVideo(videoId);
    }

    // GET http://localhost:8080/PeerTube/comments/{videoId}/{threadId}
    @GetMapping("/{videoId}/{threadId}")
    public CommentThreadPT getSpecificComment(
            @PathVariable String videoId,
            @PathVariable String threadId) {

        return commentRepository.findSpecificComment(videoId, threadId);
    }
}
