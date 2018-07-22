/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.14).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "Follow another user", nickname = "usersIdFollowFollowerIdPut", notes = "This will update the users deatils and add a user name for who they are following", tags={ "timeline", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(value = "/users/{id}/follow/{followerId}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> usersIdFollowFollowerIdPut(@ApiParam(value = "The user id that is to be updated",required=true) @PathVariable("id") Integer id,@ApiParam(value = "The user id you wish to follow",required=true) @PathVariable("followerId") Integer followerId);


    @ApiOperation(value = "check user exists", nickname = "usersIdHead", notes = "This is a simple head validation to check the user exists", tags={ "users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "User Exists"),
        @ApiResponse(code = 404, message = "Not Found") })
    @RequestMapping(value = "/users/{id}",
        method = RequestMethod.HEAD)
    ResponseEntity<Void> usersIdHead(@ApiParam(value = "The user id you want to check",required=true) @PathVariable("id") Integer id);

}
