package aiss.PeerTube.modelPT.video;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VideoPTResponse {

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("data")
    private List<VideoPT> data;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<VideoPT> getData() {
        return data;
    }

    public void setData(List<VideoPT> data) {
        this.data = data;
    }
}
