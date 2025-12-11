package br.com.spring.springsecurity.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CardsController.class)
@AutoConfigureMockMvc(addFilters = false)
class CardsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_cards_details() throws Exception {
        mockMvc.perform(get("/myCards"))
                .andExpect(status().isOk())
                .andExpect(content().string("<h1>Congratulations! You've reached Card Details!</h1>"));
    }
}