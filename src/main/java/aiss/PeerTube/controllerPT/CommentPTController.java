package aiss.PeerTube.controllerPT;

import aiss.PeerTube.exception.CommentNotFoundException;
import aiss.PeerTube.model.comment.CommentBasePT;
import aiss.PeerTube.repositoryPT.CommentPTRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("PeerTube/comments")
public class CommentPTController {
    private CommentPTRepository commentRepository;

    public CommentPTController(CommentPTRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    // GET http://localhost:8080/PeerTube/comments
    @GetMapping
    public List<CommentBasePT> getComment(){
        return commentRepository.findAll();
    }

    // GET http://localhost:8080/PeerTube/comments/{id}
    @GetMapping("/{id}")
    public CommentBasePT getCommentById(@PathVariable Integer id) throws CommentNotFoundException{
        return commentRepository.findById(id);
    }
}