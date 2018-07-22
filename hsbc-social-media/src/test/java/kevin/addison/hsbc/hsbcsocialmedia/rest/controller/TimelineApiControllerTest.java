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
public class TimelineApiControllerTest {

    @LocalServerPort
    private int port;

    private String contextPath = "social/v1";
    private String getUrl = "/timeline/1";
    private String postUrl = "/message";
    private String followUser = "/users/1/follow";

    @Autowired
    private TestRestTemplate restTemplate;

    private TestDataStub testData = TestDataStub.getInstance();

    @Before
    public void setUp() throws Exception {
        testData.setupTimeLineForTest(restTemplate, contextPath, postUrl, port, followUser);

    }

    @Test
    public void getTimelineForUserId() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/" + contextPath + getUrl,
                String.class)).contains("addca");
    }
}