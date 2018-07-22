package kevin.addison.hsbc.hsbcsocialmedia.service;

import kevin.addison.hsbc.hsbcsocialmedia.TestDataStub;
import kevin.addison.hsbc.hsbcsocialmedia.rest.controller.MessagesApiController;
import kevin.addison.hsbc.hsbcsocialmedia.rest.model.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.unprocessableEntity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MessagesApiController.class)
public class MessageServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService service;

    private TestDataStub testData = TestDataStub.getInstance();

    private static Validator validator;

    @Before
    public void setUp() throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void postMessageShouldReturnCreatedStatus() throws Exception {
        when(service.postMessage(testData.getMessageBodyForPost())).thenReturn(ok().build());
        this.mockMvc.perform(
                post("/message")
                        .accept("application/json")
                        .contentType("application/json")
                        .content(testData.getJson())
        ).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void postMessageShouldReturnValidationError() throws Exception {
        when(service.postMessage(testData.getMessageInvalidBodyForPost())).thenReturn(unprocessableEntity().build());
        this.mockMvc.perform(
                post("/message")
                        .accept("application/json")
                        .contentType("application/json")
                        .content(testData.getInvalidJson())
        ).andDo(print()).andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void testThatThereIsAValidationError() throws Exception {
        Message message = new Message();
        message.setMessage("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        Set<ConstraintViolation<Message>> violations = validator.validate(message);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void getMessagesForUser() throws Exception {
        when(service.getMessagesForUser(1)).thenReturn(testData.getResponseForGetMessage());

        this.mockMvc.perform(get("/messages/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("this is a test")))
                .andExpect(content().string(containsString("addke")));
    }
}