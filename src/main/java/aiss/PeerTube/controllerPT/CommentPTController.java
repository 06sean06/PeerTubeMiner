package aiss.PeerTube.controllerPT;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aiss.PeerTube.exception.CommentNotFoundException;
import aiss.PeerTube.model.modelPT.comment.CommentBasePT;
import aiss.PeerTube.model.modelPT.comment.CommentPTResponse;
import aiss.PeerTube.model.modelPT.comment.CommentThreadPT;
import aiss.PeerTube.repositoryPT.CommentPTRepository;

@RestController
@RequestMapping("PeerTubeMiner/comments")
public class CommentPTController {

    private final CommentPTRepository commentRepository;

    public CommentPTController(CommentPTRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // GET http://localhost:8082/PeerTubeMiner/comments/{videoId}
    @GetMapping("/{videoId}")
    public List<CommentBasePT> getCommentsByVideo(@PathVariable String videoId) {
        return commentRepository.findAllCommentsByVideo(videoId);
    }

    // GET http://localhost:8082/PeerTubeMiner/comments/{videoId}/{threadId}
    @GetMapping("/{videoId}/{threadId}")
    public CommentThreadPT getSpecificComment(
            @PathVariable String videoId,
            @PathVariable String threadId) throws CommentNotFoundException {
                CommentThreadPT comment = commentRepository.findSpecificComment(videoId, threadId);  
                if (comment == null) {
                    throw new CommentNotFoundException();
                }return comment;
    }
}
