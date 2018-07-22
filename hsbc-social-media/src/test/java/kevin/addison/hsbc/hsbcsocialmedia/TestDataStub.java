package kevin.addison.hsbc.hsbcsocialmedia;

import kevin.addison.hsbc.hsbcsocialmedia.rest.model.Message;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.MessageList;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.User;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.UserSub;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class TestDataStub {

    private static TestDataStub ourInstance = new TestDataStub();
    private MessageList messages = new MessageList();
    private Message msg = new Message(1, "this is a test", new UserSub(1, "addke"));
    private Message invalidMsg = new Message(1, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", new UserSub(1, "addke"));
    private User user = new User();
    private UserSub userSub = new UserSub(2, "addca");
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

    private String userJson = "{" +
            "  \"_id\": 2," +
            "  \"username\": \"addca\"" +
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

    public UserSub getUserBodyForPut() {
        return userSub;
    }

    public UserSub getFollowUserData() {
        UserSub userSub = new UserSub(2, "addca");
        return userSub;
    }

    public String getUserJson() {
        return userJson;
    }

    public Message getMessageBodyForSecondUserPost() {
        Message msg = new Message(1, "this is a test", new UserSub(2, "addca"));
        return msg;
    }

    public void setupTimeLineForTest(TestRestTemplate restTemplate, String contextPath, String postUrl, int port, String followUser) {
        //1st user message
        HttpEntity<Message> messageWriteRequest = new HttpEntity<>(getMessageBodyForPost());
        restTemplate
                .postForObject("http://localhost:" + port + "/" + contextPath + postUrl, messageWriteRequest, String.class);

        //seconds user msg
        messageWriteRequest = new HttpEntity<>(getMessageBodyForSecondUserPost());
        restTemplate
                .postForObject("http://localhost:" + port + "/" + contextPath + postUrl, messageWriteRequest, String.class);

        //1st user follow second user
        HttpEntity<UserSub> userFollowRequest = new HttpEntity<>(getUserBodyForPut());
        assertThat(restTemplate.exchange("http://localhost:" + port + "/" + contextPath + followUser, HttpMethod.PUT,
                userFollowRequest, String.class));
    }

    public ResponseEntity<MessageList> getResponseForGetTimeLine() {
        messages.add(msg);
        ResponseEntity<MessageList> response = new ResponseEntity<>(messages, HttpStatus.OK);
        return response;
    }
}
