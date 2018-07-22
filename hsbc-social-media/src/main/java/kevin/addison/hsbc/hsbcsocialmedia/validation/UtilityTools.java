package kevin.addison.hsbc.hsbcsocialmedia.validation;

import kevin.addison.hsbc.hsbcsocialmedia.rest.model.Message;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.MessageList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class UtilityTools {

    private static UtilityTools ourInstance = new UtilityTools();

    private UtilityTools() {
    }

    public static UtilityTools getInstance() {
        return ourInstance;
    }

    public ResponseEntity<MessageList> findMessages(Integer id, Predicate predicate, LinkedHashMap<Integer, Message> dataStorageMsg) {
        MessageList msgs = new MessageList();

        Map<Integer, Message> newMap = new TreeMap(Collections.reverseOrder());
        newMap.putAll(dataStorageMsg);

        for (Message message : newMap.values()) {
            if (predicate.matches(message, id)) {
                msgs.add(new Message(message.getId(), message.getMessage(), message.getUser()));
            }
        }

        return new ResponseEntity<>(msgs, HttpStatus.OK);
    }
}
