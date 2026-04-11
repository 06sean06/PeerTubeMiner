
package aiss.PeerTube.model.video;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "resolution",
    "width",
    "height",
    "magnetUri",
    "size",
    "fps",
    "torrentUrl",
    "fileUrl",
    "hasAudio",
    "hasVideo",
    "storage"
})
@Generated("jsonschema2pojo")
public class File {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("resolution")
    private Resolution resolution;
    @JsonProperty("width")
    private Object width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("magnetUri")
    private String magnetUri;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("fps")
    private Integer fps;
    @JsonProperty("torrentUrl")
    private String torrentUrl;
    @JsonProperty("fileUrl")
    private String fileUrl;
    @JsonProperty("hasAudio")
    private Boolean hasAudio;
    @JsonProperty("hasVideo")
    private Boolean hasVideo;
    @JsonProperty("storage")
    private Object storage;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("resolution")
    public Resolution getResolution() {
        return resolution;
    }

    @JsonProperty("resolution")
    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    @JsonProperty("width")
    public Object getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Object width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("magnetUri")
    public String getMagnetUri() {
        return magnetUri;
    }

    @JsonProperty("magnetUri")
    public void setMagnetUri(String magnetUri) {
        this.magnetUri = magnetUri;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty("fps")
    public Integer getFps() {
        return fps;
    }

    @JsonProperty("fps")
    public void setFps(Integer fps) {
        this.fps = fps;
    }

    @JsonProperty("torrentUrl")
    public String getTorrentUrl() {
        return torrentUrl;
    }

    @JsonProperty("torrentUrl")
    public void setTorrentUrl(String torrentUrl) {
        this.torrentUrl = torrentUrl;
    }

    @JsonProperty("fileUrl")
    public String getFileUrl() {
        return fileUrl;
    }

    @JsonProperty("fileUrl")
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @JsonProperty("hasAudio")
    public Boolean getHasAudio() {
        return hasAudio;
    }

    @JsonProperty("hasAudio")
    public void setHasAudio(Boolean hasAudio) {
        this.hasAudio = hasAudio;
    }

    @JsonProperty("hasVideo")
    public Boolean getHasVideo() {
        return hasVideo;
    }

    @JsonProperty("hasVideo")
    public void setHasVideo(Boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    @JsonProperty("storage")
    public Object getStorage() {
        return storage;
    }

    @JsonProperty("storage")
    public void setStorage(Object storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(File.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("resolution");
        sb.append('=');
        sb.append(((this.resolution == null)?"<null>":this.resolution));
        sb.append(',');
        sb.append("width");
        sb.append('=');
        sb.append(((this.width == null)?"<null>":this.width));
        sb.append(',');
        sb.append("height");
        sb.append('=');
        sb.append(((this.height == null)?"<null>":this.height));
        sb.append(',');
        sb.append("magnetUri");
        sb.append('=');
        sb.append(((this.magnetUri == null)?"<null>":this.magnetUri));
        sb.append(',');
        sb.append("size");
        sb.append('=');
        sb.append(((this.size == null)?"<null>":this.size));
        sb.append(',');
        sb.append("fps");
        sb.append('=');
        sb.append(((this.fps == null)?"<null>":this.fps));
        sb.append(',');
        sb.append("torrentUrl");
        sb.append('=');
        sb.append(((this.torrentUrl == null)?"<null>":this.torrentUrl));
        sb.append(',');
        sb.append("fileUrl");
        sb.append('=');
        sb.append(((this.fileUrl == null)?"<null>":this.fileUrl));
        sb.append(',');
        sb.append("hasAudio");
        sb.append('=');
        sb.append(((this.hasAudio == null)?"<null>":this.hasAudio));
        sb.append(',');
        sb.append("hasVideo");
        sb.append('=');
        sb.append(((this.hasVideo == null)?"<null>":this.hasVideo));
        sb.append(',');
        sb.append("storage");
        sb.append('=');
        sb.append(((this.storage == null)?"<null>":this.storage));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
