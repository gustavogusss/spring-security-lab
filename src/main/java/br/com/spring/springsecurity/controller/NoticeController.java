package br.com.spring.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    @GetMapping("/notices")
    public String getNotices() {
        return "Congratulations! You've reached Notices Details!";
    }
}
