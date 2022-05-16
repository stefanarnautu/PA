package com.example.compulsory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class CompulsoryApplication {

    public static void main(String[] args) {
        //SpringApplication.run(CompulsoryApplication.class, args);
        SpringApplication app = new SpringApplication(CompulsoryApplication.class);
        app.setDefaultProperties(Collections.singletonMap("127.0.0.2", "8083"));
        app.run(args);

    }

}
