package kevin.addison.hsbc.hsbcsocialmedia.rest.controller;

import io.swagger.annotations.ApiParam;
import kevin.addison.hsbc.hsbcsocialmedia.rest.api.UsersApi;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.UserSub;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class UsersApiController implements UsersApi {

    public ResponseEntity<Void> addFollowerToUser(
            @ApiParam(
                    value = "The user id that is to be updated",
                    required = true
            )
            @PathVariable("id") String id,
            @Valid @RequestBody UserSub body) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Void> usersIdHead(
            @ApiParam(value = "The user id you want to check", required = true)
            @PathVariable("id") Integer id) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
