package com.example.Group;

import com.example.Group.GroupController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(GroupController.class) public class GroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGroupPage() throws Exception {
        mockMvc.perform(get("/group"))
                .andExpect(status().isOk())
                .andExpect(view().name("group"))
                .andExpect(content().string(containsString("Welcome to...")));
    }
}
