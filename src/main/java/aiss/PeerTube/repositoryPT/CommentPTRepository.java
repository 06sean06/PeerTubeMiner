package aiss.PeerTube.repositoryPT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aiss.PeerTube.model.modelPT.comment.CommentBasePT;
import aiss.PeerTube.model.modelPT.comment.CommentThreadPT;
import aiss.PeerTube.services.CommentPTService;

@Repository
public class CommentPTRepository {

    @Autowired
    CommentPTService commentPTService;

    // GET ALL COMMENTS FROM A VIDEO
    public List<CommentBasePT> findAllCommentsByVideo(String videoId) {
        return commentPTService.getCommentsByVideo(videoId, null); //para que sea el valor por defecto el de properties
    }

    // GET ALL COMMENTS FROM A VIDEO with max limit
    public List<CommentBasePT> findAllCommentsByVideo(String videoId, Integer maxComments) {
        return commentPTService.getCommentsByVideo(videoId, maxComments);
    }

    // GET SPECIFIC COMMENT FROM A VIDEO
    public CommentThreadPT findSpecificComment(String videoId, String threadId) {
        return commentPTService.getSpecificComment(videoId, threadId);
    }
}
