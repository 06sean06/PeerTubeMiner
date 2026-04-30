package aiss.PeerTube.model.modelPT.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CommentPTResponse {

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("data")
    private List<CommentBasePT> data;

    @JsonProperty("totalNotDeletedComments")
    private Integer totalNotDeletedComments;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<CommentBasePT> getData() {
        return data;
    }

    public void setData(List<CommentBasePT> data) {
        this.data = data;
    }

    public Integer getTotalNotDeletedComments() {
        return totalNotDeletedComments;
    }

    public void setTotalNotDeletedComments(Integer totalNotDeletedComments) {
        this.totalNotDeletedComments = totalNotDeletedComments;
    }
}
