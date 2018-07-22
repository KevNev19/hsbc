package kevin.addison.hsbc.hsbcsocialmedia.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * Message
 */
@Data
public class Message {

    @JsonProperty("_id")
    private Integer id;

    @JsonProperty("message")
    @ApiModelProperty(example = "This is the message I posted", value = "")
    @Size(max = 140, message = "Message may be no longer that 140 characters")
    private String message;

    @JsonProperty("user")
    private UserSub user;

    public Message() {
    }

    public Message(int id, String message, UserSub userSub) {
        setId(id);
        setMessage(message);
        setUser(userSub);
    }
}

