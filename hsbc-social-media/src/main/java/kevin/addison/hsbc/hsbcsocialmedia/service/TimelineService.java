package kevin.addison.hsbc.hsbcsocialmedia.service;

import kevin.addison.hsbc.hsbcsocialmedia.rest.model.Message;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.MessageList;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.User;
import kevin.addison.hsbc.hsbcsocialmedia.validation.Predicate;
import kevin.addison.hsbc.hsbcsocialmedia.validation.UtilityTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class TimelineService {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    public ResponseEntity<MessageList> getTimeLine(Integer id) {

        LinkedHashMap<Integer, Message> dataStorageMsg = messageService.getDataStorageMsg();
        HashMap<Integer, User> userData = userService.getUserData();
        User user = userData.get(id);
        List<Integer> following = user.getFollowing();

        Predicate predicate = new Predicate() {
            public boolean matches(Message message, Integer id) {
                return message.getUser().getId() != id && following.contains(message.getUser().getId());
            }
        };

        return UtilityTools.getInstance().findMessages(id, predicate, dataStorageMsg);

    }
}
