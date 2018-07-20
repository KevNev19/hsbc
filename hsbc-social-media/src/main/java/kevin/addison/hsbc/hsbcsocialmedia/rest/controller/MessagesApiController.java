package kevin.addison.hsbc.hsbcsocialmedia.rest.controller;

import addison.kevin.hsbc.api.MessagesApi;
import addison.kevin.hsbc.model.MessageResponse;
import addison.kevin.hsbc.model.WallPostRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MessagesApiController implements MessagesApi {

    private static final Logger log = LoggerFactory.getLogger(MessagesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    public MessagesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @RequestMapping(
            value = "/messages/{username}",
            method = RequestMethod.GET
    )
    public ResponseEntity<MessageResponse> messagesUsernameGet(
            @ApiParam(
                    value = "The user name for the messages you want to fetch",
                    required = true
            )
            @PathVariable("username") String username) {
        return new ResponseEntity<MessageResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> postMessage(
            @ApiParam(
                    value = "Message request to the API for posting a message against a user",
                    required = true
            )
            @Valid @RequestBody WallPostRequest body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
