package kevin.addison.hsbc.hsbcsocialmedia.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * User
 */
@Validated
@Data
public class UserSub {

    @JsonProperty("_id")
    private Integer id;

    @ApiModelProperty(example = "addke", value = "")
    @JsonProperty("username")
    private String username;

    public UserSub() {
    }

    public UserSub(int id, String username) {
        this.id = id;
        this.username = username;
    }
}

