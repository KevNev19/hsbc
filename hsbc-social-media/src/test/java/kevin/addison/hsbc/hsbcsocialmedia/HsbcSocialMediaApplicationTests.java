package kevin.addison.hsbc.hsbcsocialmedia;

import kevin.addison.hsbc.hsbcsocialmedia.rest.controller.MessagesApiController;
import kevin.addison.hsbc.hsbcsocialmedia.rest.controller.TimelineApiController;
import kevin.addison.hsbc.hsbcsocialmedia.rest.controller.UsersApiController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HsbcSocialMediaApplicationTests {

    @Autowired
    private MessagesApiController messagesApiController;

    @Autowired
    private TimelineApiController timelineApiController;

    @Autowired
    private UsersApiController usersApiController;

    @Test
    public void contextLoads() {
        assertThat(messagesApiController).isNotNull();
        assertThat(timelineApiController).isNotNull();
        assertThat(usersApiController).isNotNull();
    }

}
