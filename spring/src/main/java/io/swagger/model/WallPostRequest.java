package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.UserSub;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * WallPostRequest
 */
@Validated

public class WallPostRequest   {
  @JsonProperty("user")
  private UserSub user = null;

  @JsonProperty("message")
  private String message = null;

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

  public WallPostRequest message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(example = "This is message i want to post", required = true, value = "")
  @NotNull

@Size(max=140) 
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
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
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WallPostRequest wallPostRequest = (WallPostRequest) o;
    return Objects.equals(this.user, wallPostRequest.user) &&
        Objects.equals(this.message, wallPostRequest.message) &&
        Objects.equals(this.createdOn, wallPostRequest.createdOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, message, createdOn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WallPostRequest {\n");
    
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

