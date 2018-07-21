package kevin.addison.hsbc.hsbcsocialmedia.service;

import kevin.addison.hsbc.hsbcsocialmedia.collections.MessageCollection;
import kevin.addison.hsbc.hsbcsocialmedia.collections.UserCollection;
import kevin.addison.hsbc.hsbcsocialmedia.repository.MessageRepository;
import kevin.addison.hsbc.hsbcsocialmedia.repository.UserRepository;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.Message;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.MessageList;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.WallPostRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Service
public class MessageService {

    private MessageRepository msgRepo;
    private UserRepository userRepo;

    public ResponseEntity<Void> postMessage(WallPostRequest body) {

        MessageCollection newMsg = new MessageCollection();
        newMsg.setMessage(body.getMessage());
        newMsg.setUsername(body.getUser().getUsername());

        msgRepo.save(newMsg);

        UserCollection newUser = new UserCollection();
        newUser.setFistName(body.getUser().getFirstName());
        newUser.setLastName(body.getUser().getLastName());
        newUser.setUsername(body.getUser().getFirstName());

        userRepo.save(newUser);

        return ok().build();
    }

    public ResponseEntity<MessageList> getMessagesForUser(String username) {

        List<MessageCollection> userMessages = msgRepo.findAllByUsernameOrderByCreatedOn(username);

        MessageList msgs = new MessageList();
        for (MessageCollection userMessage : userMessages) {
            Message msg = new Message();
            msg.setMessage(userMessage.getMessage());
            msgs.add(msg);
        }

        return new ResponseEntity<>(msgs, HttpStatus.OK);
    }
}
