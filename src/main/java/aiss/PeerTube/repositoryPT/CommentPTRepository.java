package aiss.PeerTube.repositoryPT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aiss.PeerTube.model.modelPT.comment.CommentPTResponse;
import aiss.PeerTube.model.modelPT.comment.CommentThreadPT;
import aiss.PeerTube.services.CommentPTService;

@Repository
public class CommentPTRepository {

    @Autowired
    CommentPTService commentPTService;

    // GET ALL COMMENTS FROM A VIDEO
    public CommentPTResponse findAllCommentsByVideo(String videoId) {
        return commentPTService.getCommentsByVideo(videoId);
    }

    // GET SPECIFIC COMMENT FROM A VIDEO
    public CommentThreadPT findSpecificComment(String videoId, String threadId) {
        return commentPTService.getSpecificComment(videoId, threadId);
    }
}
