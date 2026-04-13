
package aiss.PeerTube.modelPT.comment;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import aiss.PeerTube.model.channel.AvatarPT;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "name",
    "host",
    "avatars",
    "id",
    "hostRedundancyAllowed",
    "followingCount",
    "followersCount",
    "createdAt",
    "displayName",
    "description",
    "updatedAt"
})
@Generated("jsonschema2pojo")
public class AccountPT {

    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("host")
    private String host;
    @JsonProperty("avatars")
    private List<AvatarPT> avatars;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("hostRedundancyAllowed")
    private Boolean hostRedundancyAllowed;
    @JsonProperty("followingCount")
    private Integer followingCount;
    @JsonProperty("followersCount")
    private Integer followersCount;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty("avatars")
    public List<AvatarPT> getAvatars() {
        return avatars;
    }

    @JsonProperty("avatars")
    public void setAvatars(List<AvatarPT> avatars) {
        this.avatars = avatars;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("hostRedundancyAllowed")
    public Boolean getHostRedundancyAllowed() {
        return hostRedundancyAllowed;
    }

    @JsonProperty("hostRedundancyAllowed")
    public void setHostRedundancyAllowed(Boolean hostRedundancyAllowed) {
        this.hostRedundancyAllowed = hostRedundancyAllowed;
    }

    @JsonProperty("followingCount")
    public Integer getFollowingCount() {
        return followingCount;
    }

    @JsonProperty("followingCount")
    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    @JsonProperty("followersCount")
    public Integer getFollowersCount() {
        return followersCount;
    }

    @JsonProperty("followersCount")
    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
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
        sb.append(AccountPT.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("host");
        sb.append('=');
        sb.append(((this.host == null)?"<null>":this.host));
        sb.append(',');
        sb.append("avatars");
        sb.append('=');
        sb.append(((this.avatars == null)?"<null>":this.avatars));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("hostRedundancyAllowed");
        sb.append('=');
        sb.append(((this.hostRedundancyAllowed == null)?"<null>":this.hostRedundancyAllowed));
        sb.append(',');
        sb.append("followingCount");
        sb.append('=');
        sb.append(((this.followingCount == null)?"<null>":this.followingCount));
        sb.append(',');
        sb.append("followersCount");
        sb.append('=');
        sb.append(((this.followersCount == null)?"<null>":this.followersCount));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("displayName");
        sb.append('=');
        sb.append(((this.displayName == null)?"<null>":this.displayName));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
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
