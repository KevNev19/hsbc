package kevin.addison.hsbc.hsbcsocialmedia.service;

import kevin.addison.hsbc.hsbcsocialmedia.TestDataStub;
import kevin.addison.hsbc.hsbcsocialmedia.rest.controller.TimelineApiController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TimelineApiController.class)
public class TimelineServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TimelineService service;

    private TestDataStub testData = TestDataStub.getInstance();

    @Test
    public void getTimeLineSuccessForUser() throws Exception {
        when(service.getTimeLine(1)).thenReturn(testData.getResponseForGetTimeLine());
        this.mockMvc.perform(get("/timeline/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("this is a test")))
                .andExpect(content().string(containsString("addke")));
    }
}