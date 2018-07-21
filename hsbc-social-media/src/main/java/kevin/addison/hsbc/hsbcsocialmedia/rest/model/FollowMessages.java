package kevin.addison.hsbc.hsbcsocialmedia.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * FollowMessages
 */
@Validated
@Data
public class FollowMessages {

    @JsonProperty("username")
    @ApiModelProperty(example = "addke", value = "")
    private String username = null;

    @JsonProperty("postedDate")
    @ApiModelProperty(example = "27/02/2018", value = "")
    private String postedDate = null;

    @JsonProperty("message")
    @ApiModelProperty(example = "This is a message from another user", value = "")
    private String message = null;

    public FollowMessages username(String username) {
        this.username = username;
        return this;
    }

    public FollowMessages postedDate(String postedDate) {
        this.postedDate = postedDate;
        return this;
    }


    public FollowMessages message(String message) {
        this.message = message;
        return this;
    }
}

