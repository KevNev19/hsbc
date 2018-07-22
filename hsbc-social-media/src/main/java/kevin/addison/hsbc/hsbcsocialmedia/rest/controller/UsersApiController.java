package kevin.addison.hsbc.hsbcsocialmedia.rest.controller;

import io.swagger.annotations.ApiParam;
import kevin.addison.hsbc.hsbcsocialmedia.rest.api.UsersApi;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.UserSub;
import kevin.addison.hsbc.hsbcsocialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UsersApiController implements UsersApi {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{id}/follow",
            method = RequestMethod.PUT)
    public ResponseEntity<Void> addFollowerToUser(
            @ApiParam(
                    value = "The user id that is to be updated",
                    required = true
            )
            @PathVariable("id") Integer id,
            @Valid @RequestBody UserSub body) {
        return userService.followUser(id, body);
    }

    @Override
    public ResponseEntity<Void> usersIdHead(
            @ApiParam(value = "The user id you want to check", required = true)
            @PathVariable("id") Integer id) {
        return userService.checkUserExists(id);
    }

}
