package com.example.compulsory;

import EntityManagerPK.EntityManagerClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class CompulsoryApplication {

    public static void main(String[] args) {
        EntityManagerClass entityManagerClass = new EntityManagerClass();
        SpringApplication.run(CompulsoryApplication.class, args);

    }

}
