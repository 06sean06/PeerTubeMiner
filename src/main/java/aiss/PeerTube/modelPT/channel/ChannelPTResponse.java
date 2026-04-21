package aiss.PeerTube.modelPT.channel;

import java.util.List;

public class ChannelPTResponse {
     private Integer total;
    private List<ChannelPT> data;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<ChannelPT> getData() {
        return data;
    }

    public void setData(List<ChannelPT> data) {
        this.data = data;
    }

}
