package kevin.addison.hsbc.hsbcsocialmedia.rest.controller;

import addison.kevin.hsbc.api.TimelineApi;
import addison.kevin.hsbc.model.FollowsMessageResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TimelineApiController implements TimelineApi {

    private static final Logger log = LoggerFactory.getLogger(TimelineApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TimelineApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<FollowsMessageResponse> timelineUsernameGet(
            @ApiParam(
                    value = "The user name that si to be updated",
                    required=true
            )
            @PathVariable("username") String username) {
        return new ResponseEntity<FollowsMessageResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
