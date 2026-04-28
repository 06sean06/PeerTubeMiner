package aiss.PeerTube.model.modelPT.caption;

import java.util.List;

public class CaptionPTResponse {

    private Integer total;
    private List<CaptionPT> data;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<CaptionPT> getData() {
        return data;
    }

    public void setData(List<CaptionPT> data) {
        this.data = data;
    }
}
