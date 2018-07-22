package kevin.addison.hsbc.hsbcsocialmedia.rest.controller;

import io.swagger.annotations.ApiParam;
import kevin.addison.hsbc.hsbcsocialmedia.rest.api.TimelineApi;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.MessageList;
import kevin.addison.hsbc.hsbcsocialmedia.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TimelineApiController implements TimelineApi {

    @Autowired
    private TimelineService service;

    @Autowired
    public TimelineApiController() {
    }

    public ResponseEntity<MessageList> getTimelineForUserId(
            @ApiParam(
                    value = "The user name that si to be updated",
                    required = true
            )
            @PathVariable("id") Integer id) {
        return service.getTimeLine(id);
    }

}
