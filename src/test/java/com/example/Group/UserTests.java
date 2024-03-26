package com.example.Group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UserTests {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @BeforeEach
    public void setMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    //  Пользовательский доступ
    @Test
    @WithMockUser
    void UserToMain() throws Exception{
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void UserToFaculty() throws Exception{
        mockMvc.perform(get("/faculty")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void UserToChair() throws Exception{
        mockMvc.perform(get("/chair")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void UserToLogin() throws Exception{
        mockMvc.perform(get("/login")).andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    void UserToRegister() throws Exception{
        mockMvc.perform(get("/registration")).andExpect(status().isForbidden());
    }
}
