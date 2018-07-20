package kevin.addison.hsbc.hsbcsocialmedia.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * FollowMessages
 */
@Validated

public class FollowMessages   {
  @JsonProperty("username")
  private String username = null;

  @JsonProperty("postedDate")
  private String postedDate = null;

  @JsonProperty("message")
  private String message = null;

  public FollowMessages username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
  **/
  @ApiModelProperty(example = "addke", value = "")


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public FollowMessages postedDate(String postedDate) {
    this.postedDate = postedDate;
    return this;
  }

  /**
   * Get postedDate
   * @return postedDate
  **/
  @ApiModelProperty(example = "27/02/2018", value = "")


  public String getPostedDate() {
    return postedDate;
  }

  public void setPostedDate(String postedDate) {
    this.postedDate = postedDate;
  }

  public FollowMessages message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(example = "This is a message from another user", value = "")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FollowMessages followMessages = (FollowMessages) o;
    return Objects.equals(this.username, followMessages.username) &&
        Objects.equals(this.postedDate, followMessages.postedDate) &&
        Objects.equals(this.message, followMessages.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, postedDate, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FollowMessages {\n");

    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    postedDate: ").append(toIndentedString(postedDate)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

