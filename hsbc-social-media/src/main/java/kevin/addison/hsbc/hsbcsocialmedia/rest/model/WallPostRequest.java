package kevin.addison.hsbc.hsbcsocialmedia.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * WallPostRequest
 */
@Validated
@Data
public class WallPostRequest {
    @JsonProperty("user")
    private User user = null;

    @JsonProperty("message")
    private String message = null;

    @JsonProperty("createdOn")
    private String createdOn = null;

}

