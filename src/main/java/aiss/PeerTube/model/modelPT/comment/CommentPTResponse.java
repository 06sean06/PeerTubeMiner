package aiss.PeerTube.model.modelPT.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CommentPTResponse {

    @JsonProperty("data")
    private List<CommentThreadPT> data;

    
    @JsonProperty("data") 
    private List<CommentBasePT> dataBase;

    public List<CommentThreadPT> getData() {
        return data;
    }

    public void setData(List<CommentThreadPT> data) {
        this.data = data;
    }

    public List<CommentBasePT> getDataBase() {
        return dataBase;
    }

    public void setDataBase(List<CommentBasePT> dataBase) {
        this.dataBase = dataBase;
    }
}
    

