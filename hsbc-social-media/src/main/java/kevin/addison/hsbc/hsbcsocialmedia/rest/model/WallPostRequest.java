package kevin.addison.hsbc.hsbcsocialmedia.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * WallPostRequest
 */
@Validated

public class WallPostRequest   {
  @JsonProperty("user")
  private UserSub user = null;

  @JsonProperty("post")
  private String post = null;

  @JsonProperty("createdOn")
  private String createdOn = null;

  public WallPostRequest user(UserSub user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UserSub getUser() {
    return user;
  }

  public void setUser(UserSub user) {
    this.user = user;
  }

  public WallPostRequest post(String post) {
    this.post = post;
    return this;
  }

  /**
   * Get post
   * @return post
  **/
  @ApiModelProperty(example = "This is message i want to post", required = true, value = "")
  @NotNull

@Size(max=140)
  public String getPost() {
    return post;
  }

  public void setPost(String post) {
    this.post = post;
  }

  public WallPostRequest createdOn(String createdOn) {
    this.createdOn = createdOn;
    return this;
  }

  /**
   * Get createdOn
   * @return createdOn
  **/
  @ApiModelProperty(example = "20/07/2018", value = "")


  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WallPostRequest wallPostRequest = (WallPostRequest) o;
    return Objects.equals(this.user, wallPostRequest.user) &&
        Objects.equals(this.post, wallPostRequest.post) &&
        Objects.equals(this.createdOn, wallPostRequest.createdOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, post, createdOn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WallPostRequest {\n");

    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    post: ").append(toIndentedString(post)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

