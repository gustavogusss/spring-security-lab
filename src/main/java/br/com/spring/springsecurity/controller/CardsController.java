package br.com.spring.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/myCards")
    public String getCardDetails() {
        return "<h1>Congratulations! You've reached Card Details!</h1>";
    }

}
