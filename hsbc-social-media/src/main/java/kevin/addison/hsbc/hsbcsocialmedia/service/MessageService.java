package kevin.addison.hsbc.hsbcsocialmedia.service;

import kevin.addison.hsbc.hsbcsocialmedia.rest.model.Message;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.MessageList;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.User;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.UserSub;
import kevin.addison.hsbc.hsbcsocialmedia.validation.Predicate;
import kevin.addison.hsbc.hsbcsocialmedia.validation.UtilityTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.*;

import static org.springframework.http.ResponseEntity.created;

@Service
public class MessageService {

    private LinkedHashMap<Integer, Message> dataStorageMsg = new LinkedHashMap<>();

    @Autowired
    private UserService userService = new UserService();
    private Integer key = 1;
    private Predicate predicate;

    public ResponseEntity<Void> postMessage(Message body) {

        checkUserExists(body.getUser());

        body.setId(key);
        dataStorageMsg.put(key, body);

        key++;

        return created(URI.create("/" + body.getId())).build();
    }

    private void checkUserExists(UserSub user) {
        HashMap<Integer, User> userData = userService.getUserData();
        if (!userData.containsValue(user.getUsername())) {
            userService.createUser(user);
        }
    }

    public ResponseEntity<MessageList> getMessagesForUser(Integer id) {

        Predicate predicate = new Predicate() {
            public boolean matches(Message message, Integer id) {
                return message.getUser().getId() == id;
            }
        };

        return UtilityTools.getInstance().findMessages(id, predicate, dataStorageMsg);
    }

    public LinkedHashMap<Integer, Message> getDataStorageMsg() {
        return dataStorageMsg;
    }
}
