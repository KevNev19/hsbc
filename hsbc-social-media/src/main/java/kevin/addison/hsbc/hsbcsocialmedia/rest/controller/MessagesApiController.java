package kevin.addison.hsbc.hsbcsocialmedia.rest.controller;

import io.swagger.annotations.ApiParam;
import kevin.addison.hsbc.hsbcsocialmedia.rest.api.MessagesApi;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.Message;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.MessageList;
import kevin.addison.hsbc.hsbcsocialmedia.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class MessagesApiController implements MessagesApi {

    private static final Logger log = LoggerFactory.getLogger(MessagesApiController.class);

    @Autowired
    private MessageService messageService;

    @Autowired
    public MessagesApiController() {
    }

    @RequestMapping(
            value = "/messages/{id}",
            method = RequestMethod.GET
    )
    public ResponseEntity<MessageList> messagesUsernameGet(
            @ApiParam(
                    value = "The user name for the messages you want to fetch",
                    required = true
            )
            @PathVariable("id") Integer id) {
        return messageService.getMessagesForUser(id);
    }

    public ResponseEntity<Void> postMessage(
            @ApiParam(
                    value = "Message request to the API for posting a message against a user",
                    required = true
            )
            @Validated @RequestBody Message body) {
        return messageService.postMessage(body);
    }

}
