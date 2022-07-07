package knap.jakub.itemsManagement.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import knap.jakub.itemsManagement.repository.ItemRepository;
import knap.jakub.itemsManagement.service.ItemService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @Test
    void shouldGetItemsOfUser() throws Exception {
        String token = LoginAndGetToken();
        mockMvc.perform(get("/item")
                        .header("Authorization", token))
                .andDo(print())
                .andExpect(status().is(200));
    }

    @Test
    void shouldSaveItem() throws Exception {
        String token = LoginAndGetToken();
        mockMvc.perform(post("/item")
                        .header("Authorization", token)
                        .contentType(APPLICATION_JSON_UTF8)
                        .content("{\"name\":\"test2\"}"))
                .andDo(print())
                .andExpect(status().is(201));
    }

    private String LoginAndGetToken() throws Exception {
        MvcResult login = mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("username", "test")
                        .param("password", "test"))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();
        String authorization = login.getResponse().getContentAsString().substring(17, 160);
        String token = "Bearer ".concat(authorization);
        return token;
    }

}