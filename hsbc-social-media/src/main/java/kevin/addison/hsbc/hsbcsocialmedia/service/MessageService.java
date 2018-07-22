package kevin.addison.hsbc.hsbcsocialmedia.service;

import kevin.addison.hsbc.hsbcsocialmedia.rest.model.Message;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.MessageList;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.User;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.UserSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.springframework.http.ResponseEntity.created;

@Service
public class MessageService {

    private LinkedHashMap<Integer, Message> dataStorageMsg = new LinkedHashMap<>();

    @Autowired
    private UserService userService = new UserService();

    public ResponseEntity<Void> postMessage(Message body) {

//        checkUserExists(body.getUser());
        return created(URI.create("/" + body.getId())).build();
    }

    private void checkUserExists(UserSub user) {
        HashMap<Integer, User> userData = userService.getUserData();
        if(!userData.containsValue(user.getUsername())) {
            userService.createUser(user);
        }
    }

    public ResponseEntity<MessageList> getMessagesForUser(Integer id) {

        MessageList messages = new MessageList();

        messages.add(new Message(1, "this is a message", new UserSub(1, "addke")));

        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    public LinkedHashMap<Integer, Message> getDataStorageMsg() {
        return dataStorageMsg;
    }
}
