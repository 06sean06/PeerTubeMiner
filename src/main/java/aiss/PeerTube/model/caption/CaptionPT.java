
package aiss.PeerTube.model.caption;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "language",
    "automaticallyGenerated",
    "captionPath",
    "fileUrl",
    "m3u8Url",
    "updatedAt"
})
@Generated("jsonschema2pojo")
public class CaptionPT {

    @JsonProperty("language")
    private LanguagePT language;
    @JsonProperty("automaticallyGenerated")
    private Boolean automaticallyGenerated;
    @JsonProperty("captionPath")
    private String captionPath;
    @JsonProperty("fileUrl")
    private String fileUrl;
    @JsonProperty("m3u8Url")
    private Object m3u8Url;
    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("language")
    public LanguagePT getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(LanguagePT language) {
        this.language = language;
    }

    @JsonProperty("automaticallyGenerated")
    public Boolean getAutomaticallyGenerated() {
        return automaticallyGenerated;
    }

    @JsonProperty("automaticallyGenerated")
    public void setAutomaticallyGenerated(Boolean automaticallyGenerated) {
        this.automaticallyGenerated = automaticallyGenerated;
    }

    @JsonProperty("captionPath")
    public String getCaptionPath() {
        return captionPath;
    }

    @JsonProperty("captionPath")
    public void setCaptionPath(String captionPath) {
        this.captionPath = captionPath;
    }

    @JsonProperty("fileUrl")
    public String getFileUrl() {
        return fileUrl;
    }

    @JsonProperty("fileUrl")
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @JsonProperty("m3u8Url")
    public Object getM3u8Url() {
        return m3u8Url;
    }

    @JsonProperty("m3u8Url")
    public void setM3u8Url(Object m3u8Url) {
        this.m3u8Url = m3u8Url;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CaptionPT.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null)?"<null>":this.language));
        sb.append(',');
        sb.append("automaticallyGenerated");
        sb.append('=');
        sb.append(((this.automaticallyGenerated == null)?"<null>":this.automaticallyGenerated));
        sb.append(',');
        sb.append("captionPath");
        sb.append('=');
        sb.append(((this.captionPath == null)?"<null>":this.captionPath));
        sb.append(',');
        sb.append("fileUrl");
        sb.append('=');
        sb.append(((this.fileUrl == null)?"<null>":this.fileUrl));
        sb.append(',');
        sb.append("m3u8Url");
        sb.append('=');
        sb.append(((this.m3u8Url == null)?"<null>":this.m3u8Url));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
