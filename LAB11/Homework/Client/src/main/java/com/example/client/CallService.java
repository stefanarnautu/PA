package com.example.client;

import entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Locale;

@RestController
public class CallService {
    final Logger log = LoggerFactory.getLogger(CallService.class);
    private String uri;
    public List<Person> getPerson() {
        uri = "http://localhost:8090/people/all";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Person>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>(){});
        List<Person> result = response.getBody();
        log.info("Succes");
        return result;
    }

    public void registerPerson(String name) {
        uri = "http://localhost:8090/people/login?name="+name.toLowerCase(Locale.ROOT);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, null, new ParameterizedTypeReference<String>() {
        });
        String result = response.getBody();
        log.info(result);
    }
}
