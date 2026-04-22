package aiss.PeerTube.repositoryPT;
import aiss.PeerTube.modelPT.comment.CommentBasePT;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentPTRepository {
    private List<CommentBasePT> comments = new ArrayList<>();

    public List<CommentBasePT> findAll(){
        return comments;
    }
    public CommentBasePT findById(Integer id){
        return comments.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);

    }
    public void save (CommentBasePT comment){
        comments.add(comment);
    }
    
}
