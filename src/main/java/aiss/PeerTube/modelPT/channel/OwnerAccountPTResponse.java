package aiss.PeerTube.modelPT.channel;

public class OwnerAccountPTResponse {
    private Integer total;
    private OwnerAccountPT[] data;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public OwnerAccountPT[] getData() {
        return data;
    }

    public void setData(OwnerAccountPT[] data) {
        this.data = data;
    }
    
}
