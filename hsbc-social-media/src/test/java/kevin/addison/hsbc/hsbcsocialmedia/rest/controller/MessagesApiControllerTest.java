package kevin.addison.hsbc.hsbcsocialmedia.rest.controller;

import kevin.addison.hsbc.hsbcsocialmedia.TestDataStub;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessagesApiControllerTest {

    @LocalServerPort
    private int port;

    private String contextPath = "social/v1";
    private String getUrl = "/messages/1";
    private String postUrl = "/message";

    @Autowired
    private TestRestTemplate restTemplate;

    private TestDataStub testData = TestDataStub.getInstance();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void postMessageShouldReturnOk() {

        HttpEntity<Message> request = new HttpEntity<>(testData.getMessageBodyForPost());
        assertThat(this.restTemplate
                .postForObject("http://localhost:" + port + "/" + contextPath + postUrl, request, String.class));
    }

    @Test
    public void getMessagesForAUserShouldReturnOK() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/" + contextPath + getUrl,
                String.class)).contains("this is a message");
    }
}