package knap.jakub.itemsManagement.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.transaction.Transactional;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AppUserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldLoginAndGetContentAndTryAuthorization() throws Exception {
        MvcResult login = mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("username", "test")
                        .param("password", "test"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        String authorization = login.getResponse().getContentAsString().substring(17, 160);
        String token = "Bearer ".concat(authorization);

        mockMvc.perform(get("/secured")
                .header("Authorization", token))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(content().string("secured"));
    }

    @Test
    void shouldRegisterAndGetContent() throws Exception {
        mockMvc.perform(post("/register")
                .contentType(APPLICATION_JSON_UTF8)
                .content("{\"username\":\"test34\",\"password\":\"test3\"}"))
                .andDo(print())
                .andExpect(status().is(201));
    }

    @Test
    void shouldNotGetAuthorization() throws Exception {
        mockMvc.perform(get("/secured"))
                .andDo(print())
                .andExpect(status().is(403));
    }

}