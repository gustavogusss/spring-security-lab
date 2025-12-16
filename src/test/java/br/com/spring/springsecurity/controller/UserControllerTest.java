package br.com.spring.springsecurity.controller;

import br.com.spring.springsecurity.model.Customer;
import br.com.spring.springsecurity.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CustomerRepository customerRepository;
    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    void registerUser_shouldEncodePassword_saveCustomer_andReturn201() throws Exception {
        Customer request = new Customer();
        request.setEmail("vanessa@example.com");
        request.setPassword("vanessa");
        request.setRole("user");

        when(passwordEncoder.encode("vanessa")).thenReturn("hashed-vanessa");

        Customer saved = new Customer();
        saved.setId(1L);
        saved.setEmail("vanessa@example.com");
        saved.setPassword("hashed-vanessa");
        saved.setRole("user");

        when(customerRepository.save(any(Customer.class))).thenReturn(saved);

        mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(content().string("User registered successfully"));

        verify(passwordEncoder).encode("vanessa");

        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).save(captor.capture());

        Customer customerPassedToSave = captor.getValue();
        assertThat(customerPassedToSave.getEmail()).isEqualTo("vanessa@example.com");
        assertThat(customerPassedToSave.getRole()).isEqualTo("user");
        assertThat(customerPassedToSave.getPassword()).isEqualTo("hashed-vanessa");
    }

    @Test
    void registerUser_whenRepositoryThrows_shouldReturn500WithMessage() throws Exception {
        Customer request = new Customer();
        request.setEmail("vanessa@example.com");
        request.setPassword("vanessa");
        request.setRole("user");

        when(passwordEncoder.encode("vanessa")).thenReturn("hashed-vanessa");
        when(customerRepository.save(any(Customer.class)))
                .thenThrow(new RuntimeException("DB is down"));

        mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("An exception ocurred: DB is down"));

        verify(passwordEncoder).encode("vanessa");
        verify(customerRepository).save(any(Customer.class));
    }

    @Test
    void registerUser_whenEncoderThrows_shouldReturn500WithMessage_andNotSave() throws Exception {
        Customer request = new Customer();
        request.setEmail("vanessa@example.com");
        request.setPassword("vanessa");
        request.setRole("user");

        when(passwordEncoder.encode("vanessa"))
                .thenThrow(new IllegalStateException("Encoder failure"));

        mockMvc.perform(post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("An exception ocurred: Encoder failure"));

        verify(passwordEncoder).encode("vanessa");
        verify(customerRepository, never()).save(any());
    }
}