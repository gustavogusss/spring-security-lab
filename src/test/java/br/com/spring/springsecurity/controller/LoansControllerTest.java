package br.com.spring.springsecurity.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoansController.class)
@AutoConfigureMockMvc(addFilters = false)
class LoansControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_loans_details() throws Exception {
        mockMvc.perform(get("/myLoans"))
                .andExpect(status().isOk())
                .andExpect(content().string("<h1>Congratulations! You've reached Loans Details!</h1>"));
    }
}