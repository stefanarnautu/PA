package com.example.compulsory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllers {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Greetings from Spring Boot!";
    }
}
