package br.com.spring.springsecurity.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoansControllerSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_401_when_no_credentials() throws Exception {
        mockMvc.perform(get("/myLoans"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void should_return_200_when_admin_credentials_are_valid() throws Exception {
        mockMvc.perform(get("/myLoans")
                        .with(httpBasic("admin", "admin")))
                .andExpect(status().isOk());
    }
}
