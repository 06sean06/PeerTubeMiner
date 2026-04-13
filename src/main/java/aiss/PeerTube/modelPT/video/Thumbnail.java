
package aiss.PeerTube.modelPT.video;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "height",
    "width",
    "aspectRatio",
    "fileUrl"
})
@Generated("jsonschema2pojo")
public class Thumbnail {

    @JsonProperty("height")
    private Integer height;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("aspectRatio")
    private String aspectRatio;
    @JsonProperty("fileUrl")
    private String fileUrl;

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("aspectRatio")
    public String getAspectRatio() {
        return aspectRatio;
    }

    @JsonProperty("aspectRatio")
    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    @JsonProperty("fileUrl")
    public String getFileUrl() {
        return fileUrl;
    }

    @JsonProperty("fileUrl")
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Thumbnail.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("height");
        sb.append('=');
        sb.append(((this.height == null)?"<null>":this.height));
        sb.append(',');
        sb.append("width");
        sb.append('=');
        sb.append(((this.width == null)?"<null>":this.width));
        sb.append(',');
        sb.append("aspectRatio");
        sb.append('=');
        sb.append(((this.aspectRatio == null)?"<null>":this.aspectRatio));
        sb.append(',');
        sb.append("fileUrl");
        sb.append('=');
        sb.append(((this.fileUrl == null)?"<null>":this.fileUrl));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
