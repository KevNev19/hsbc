/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.14).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package kevin.addison.hsbc.hsbcsocialmedia.rest.api;

import io.swagger.annotations.*;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.Message;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.MessageList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Api(value = "timeline", description = "the timeline API")
public interface TimelineApi {

    @ApiOperation(
            value = "Get timeline info of all followers",
            nickname = "getTimelineForUserId",
            notes = "This allows a user to see all their followers messages",
            response = MessageList.class,
            tags = {"timeline",}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            code = 200,
                            message = "OK",
                            response = MessageList.class
                    ),
                    @ApiResponse(
                            code = 404,
                            message = "Not Found"
                    )
            }
    )
    @RequestMapping(value = "/timeline/{id}",
            method = RequestMethod.GET)
    ResponseEntity<MessageList> getTimelineForUserId(
            @ApiParam(
                    value = "The user name that si to be updated",
                    required = true
            )
            @PathVariable("id") String id
    );

}