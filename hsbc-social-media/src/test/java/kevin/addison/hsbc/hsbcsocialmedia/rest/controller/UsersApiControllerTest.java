package kevin.addison.hsbc.hsbcsocialmedia.rest.controller;

import kevin.addison.hsbc.hsbcsocialmedia.TestDataStub;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.Message;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.UserSub;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersApiControllerTest {

    @LocalServerPort
    private int port;

    private String contextPath = "social/v1";
    private String headUrl = "/users/1";
    private String patchUrl = "/users/1/follow/2";
    private String postUrl = "/message";

    @Autowired
    private TestRestTemplate restTemplate;

    private TestDataStub testData = TestDataStub.getInstance();

    @Before
    public void setUp() throws Exception {
        HttpEntity<Message> request = new HttpEntity<>(testData.getMessageBodyForPost());
        this.restTemplate
                .postForObject("http://localhost:" + port + "/" + contextPath + postUrl, request, String.class);
    }

    @Test
    public void userCanFolllowAnotherUser() {
        HttpEntity<UserSub> request = new HttpEntity<>(testData.getUserBodyForPut());
        assertThat(this.restTemplate.exchange("http://localhost:" + port + "/" + contextPath + headUrl, HttpMethod.PUT,
                request, String.class));
    }

    @Test
    public void usersExistsWithHeadCheck() {
        HttpEntity<Message> request = new HttpEntity<>(testData.getMessageBodyForPost());
        assertThat(
                this.restTemplate.exchange("http://localhost:" + port + "/" + contextPath + headUrl, HttpMethod.HEAD,
                        request, String.class));
    }
}