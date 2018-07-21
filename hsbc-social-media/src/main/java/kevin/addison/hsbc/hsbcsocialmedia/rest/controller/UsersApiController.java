package kevin.addison.hsbc.hsbcsocialmedia.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import kevin.addison.hsbc.hsbcsocialmedia.rest.api.UsersApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UsersApiController implements UsersApi {

    public ResponseEntity<Void> addFollowerToUser(
            @ApiParam(
                    value = "The user name that si to be updated",
                    required = true
            )
            @PathVariable("username") String username,
            @ApiParam(value = "The user you wish to follow", required = true)
            @PathVariable("followUserName") String followUserName) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}