package kevin.addison.hsbc.hsbcsocialmedia.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.validation.annotation.Validated;

/**
 * Message
 */
@Validated
@Data
public class Message {

    @JsonProperty("message")
    @ApiModelProperty(example = "This is the message I posted", value = "")
    private String message = null;

    @JsonProperty("createdOn")
    @CreatedDate
    @ApiModelProperty(example = "20/07/2018", value = "")
    private String createdOn = null;

}

