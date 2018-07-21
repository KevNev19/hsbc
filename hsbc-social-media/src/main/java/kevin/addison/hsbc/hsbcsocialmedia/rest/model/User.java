package kevin.addison.hsbc.hsbcsocialmedia.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * User
 */
@Validated
@Data
public class User {

    @ApiModelProperty(example = "addke", value = "")
    @JsonProperty("username")
    private String username = null;

    @JsonProperty("firstName")
    @ApiModelProperty(example = "Kevin", value = "")
    private String firstName = null;

    @JsonProperty("lastName")
    @ApiModelProperty(example = "Addison", value = "")
    private String lastName = null;

}

