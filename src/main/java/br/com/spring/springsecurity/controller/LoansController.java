package br.com.spring.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoansController {

    @GetMapping("/myLoans")
    public String getLoans(Principal principal) {
        return "<h1>Welcome, " + principal.getName() + "! You've reached Loans Details!</h1>";
    }

}
