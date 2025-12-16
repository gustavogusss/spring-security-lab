package br.com.spring.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class BalanceController {

    @GetMapping("/myBalance")
    public String getBalanceDetails(Principal principal) {
        return "<h1>Welcome, " + principal.getName() + "! You've reached Balance Details!</h1>";
    }

}
