package br.com.spring.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/Contact")
    public String saveContactInquiryDetails() {
        return "Congratulations! You've reached Contact Details!";
    }
}
