package com.example.demo.controller.impl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.repository.EmployeeAccountRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.EmployeeAccountServiceImpl;

@WebMvcTest(RegisterController.class)
@AutoConfigureMockMvc(addFilters = false)
class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private UserRepository userRepository;
    @MockitoBean
    private EmployeeAccountServiceImpl employeeAccountService;
    @MockitoBean
    private EmployeeAccountRepository employeeAccountRepository;

    @Test
    void testShowRegisterForm() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
    }
}
// @Test
// void testRegister() throws Exception {
// mockMvc.perform(post("/register")
// .param("employeeId", "1")
// .param("name", "tarako")
// .param("password", "password"))
// .andExpect(status().is3xxRedirection())
// .andExpect(redirectedUrl("/login?registered"));
// }
