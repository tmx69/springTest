package com.example.demo;

import com.example.demo.Controller.UserController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTests {
    @Autowired
    private MockMvc mvc;
//
    @MockBean
    private UserController userController;
    @Test
    public void loginTest() throws Exception {
        JSONObject actual = new JSONObject();
        actual.put("name1","user1");
        actual.put("org", "default");
        actual.put("secret", "secret");
        MediaType MEDIA_TYPE_JSON_UTF8 = new MediaType("application", "json", StandardCharsets.UTF_8);
        RequestBuilder request = MockMvcRequestBuilders
                .post("/login")
                .content(actual.toString())
                .accept(MEDIA_TYPE_JSON_UTF8)
                .contentType(MEDIA_TYPE_JSON_UTF8);
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode a = mapper.createObjectNode();
//        ((ObjectNode)a).put("name111","user1");
//        ((ObjectNode)a).put("org", "default");
//        ((ObjectNode)a).put("secret", "secret");
//        userController.login(a);
//
        mvc.perform(request)
                .andExpect(status().isOk()).andDo(print());
    }


}
