package kevin.addison.hsbc.hsbcsocialmedia;

import kevin.addison.hsbc.hsbcsocialmedia.rest.model.Message;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.MessageList;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.User;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.UserSub;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TestDataStub {

    private static TestDataStub ourInstance = new TestDataStub();
    private MessageList messages = new MessageList();
    private Message msg = new Message(1, "this is a test", new UserSub(1, "addke"));
    private Message invalidMsg = new Message(1, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", new UserSub(1, "addke"));
    private User user = new User();
    private UserSub userSub = new UserSub(1, "addke");
    private String messageJson = "{" +
            "  \"message\": \"this is a test\"," +
            "  \"user\": {" +
            "    \"_id\": 1," +
            "    \"username\": \"addke\"" +
            "  }" +
            "}";
    private String invalidJson = "{" +
            "  \"message\": \"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"," +
            "  \"user\": {" +
            "    \"_id\": 1," +
            "    \"username\": \"addke\"" +
            "  }" +
            "}";

    public static TestDataStub getInstance() {
        return ourInstance;
    }

    public ResponseEntity<MessageList> getResponseForGetMessage() {

        messages.add(msg);
        ResponseEntity<MessageList> response = new ResponseEntity<>(messages, HttpStatus.OK);
        return response;
    }

    public Message getMessageBodyForPost() {
        return msg;
    }

    public String getJson() {
        return messageJson;
    }

    public String getInvalidJson() {
        return invalidJson;
    }

    public Message getMessageInvalidBodyForPost() {
        return invalidMsg;
    }
}
