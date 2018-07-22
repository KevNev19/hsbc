package kevin.addison.hsbc.hsbcsocialmedia.service;

import kevin.addison.hsbc.hsbcsocialmedia.TestDataStub;
import kevin.addison.hsbc.hsbcsocialmedia.rest.controller.UsersApiController;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.UserSub;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UsersApiController.class)
public class UserServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    private TestDataStub testData = TestDataStub.getInstance();


    @Before
    public void setUp() throws Exception {
        service.createUser(new UserSub(1, "addke"));
        service.createUser(new UserSub(2, "addca"));
    }

    @Test
    public void followUserSuccess() throws Exception {
        when(service.followUser(1, testData.getFollowUserData())).thenReturn(ResponseEntity.ok().build());
        this.mockMvc.perform(
                put("/users/1/follow")
                        .accept("application/json")
                        .contentType("application/json")
                        .content(testData.getUserJson())
        ).andDo(print()).andExpect(status().isOk());
    }
}