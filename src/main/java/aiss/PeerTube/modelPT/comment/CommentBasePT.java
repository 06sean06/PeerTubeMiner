
package aiss.PeerTube.modelPT.comment;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "url",
    "text",
    "threadId",
    "inReplyToCommentId",
    "videoId",
    "createdAt",
    "updatedAt",
    "deletedAt",
    "heldForReview",
    "isDeleted",
    "totalRepliesFromVideoAuthor",
    "totalReplies",
    "account"
})
@Generated("jsonschema2pojo")
public class CommentBasePT {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("text")
    private String text;
    @JsonProperty("threadId")
    private Integer threadId;
    @JsonProperty("inReplyToCommentId")
    private Object inReplyToCommentId;
    @JsonProperty("videoId")
    private Integer videoId;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("deletedAt")
    private Object deletedAt;
    @JsonProperty("heldForReview")
    private Boolean heldForReview;
    @JsonProperty("isDeleted")
    private Boolean isDeleted;
    @JsonProperty("totalRepliesFromVideoAuthor")
    private Integer totalRepliesFromVideoAuthor;
    @JsonProperty("totalReplies")
    private Integer totalReplies;
    @JsonProperty("account")
    private AccountPT account;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("threadId")
    public Integer getThreadId() {
        return threadId;
    }

    @JsonProperty("threadId")
    public void setThreadId(Integer threadId) {
        this.threadId = threadId;
    }

    @JsonProperty("inReplyToCommentId")
    public Object getInReplyToCommentId() {
        return inReplyToCommentId;
    }

    @JsonProperty("inReplyToCommentId")
    public void setInReplyToCommentId(Object inReplyToCommentId) {
        this.inReplyToCommentId = inReplyToCommentId;
    }

    @JsonProperty("videoId")
    public Integer getVideoId() {
        return videoId;
    }

    @JsonProperty("videoId")
    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("deletedAt")
    public Object getDeletedAt() {
        return deletedAt;
    }

    @JsonProperty("deletedAt")
    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    @JsonProperty("heldForReview")
    public Boolean getHeldForReview() {
        return heldForReview;
    }

    @JsonProperty("heldForReview")
    public void setHeldForReview(Boolean heldForReview) {
        this.heldForReview = heldForReview;
    }

    @JsonProperty("isDeleted")
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    @JsonProperty("isDeleted")
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @JsonProperty("totalRepliesFromVideoAuthor")
    public Integer getTotalRepliesFromVideoAuthor() {
        return totalRepliesFromVideoAuthor;
    }

    @JsonProperty("totalRepliesFromVideoAuthor")
    public void setTotalRepliesFromVideoAuthor(Integer totalRepliesFromVideoAuthor) {
        this.totalRepliesFromVideoAuthor = totalRepliesFromVideoAuthor;
    }

    @JsonProperty("totalReplies")
    public Integer getTotalReplies() {
        return totalReplies;
    }

    @JsonProperty("totalReplies")
    public void setTotalReplies(Integer totalReplies) {
        this.totalReplies = totalReplies;
    }

    @JsonProperty("account")
    public AccountPT getAccount() {
        return account;
    }

    @JsonProperty("account")
    public void setAccount(AccountPT account) {
        this.account = account;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommentBasePT.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("text");
        sb.append('=');
        sb.append(((this.text == null)?"<null>":this.text));
        sb.append(',');
        sb.append("threadId");
        sb.append('=');
        sb.append(((this.threadId == null)?"<null>":this.threadId));
        sb.append(',');
        sb.append("inReplyToCommentId");
        sb.append('=');
        sb.append(((this.inReplyToCommentId == null)?"<null>":this.inReplyToCommentId));
        sb.append(',');
        sb.append("videoId");
        sb.append('=');
        sb.append(((this.videoId == null)?"<null>":this.videoId));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
        sb.append(',');
        sb.append("deletedAt");
        sb.append('=');
        sb.append(((this.deletedAt == null)?"<null>":this.deletedAt));
        sb.append(',');
        sb.append("heldForReview");
        sb.append('=');
        sb.append(((this.heldForReview == null)?"<null>":this.heldForReview));
        sb.append(',');
        sb.append("isDeleted");
        sb.append('=');
        sb.append(((this.isDeleted == null)?"<null>":this.isDeleted));
        sb.append(',');
        sb.append("totalRepliesFromVideoAuthor");
        sb.append('=');
        sb.append(((this.totalRepliesFromVideoAuthor == null)?"<null>":this.totalRepliesFromVideoAuthor));
        sb.append(',');
        sb.append("totalReplies");
        sb.append('=');
        sb.append(((this.totalReplies == null)?"<null>":this.totalReplies));
        sb.append(',');
        sb.append("account");
        sb.append('=');
        sb.append(((this.account == null)?"<null>":this.account));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
