package com.example.client;

import entity.MessageObject;
import entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
        uri = "http://localhost:8090/people/register?name="+name.toLowerCase(Locale.ROOT);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, null, new ParameterizedTypeReference<String>() {
        });
        String result = response.getBody();
        log.info(result);
    }

    public void sendMessage(String[] allCommand, String name){
        int contor = 0;
        String messageComplet = "";
        for(String str : allCommand) {
            if(contor>0)
                messageComplet += str + " ";
            contor++;
        }
        uri = "http://localhost:8090/people/messages/write?name="+name.toLowerCase(Locale.ROOT)+ "&message=" + messageComplet;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, null, new ParameterizedTypeReference<String>() {
        });
        String result = response.getBody();
        log.info(result);
    }

    public void readAllMessages(){
        uri = "http://localhost:8090/people/messages/get";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<MessageObject>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<MessageObject>>(){});
        List<MessageObject> result = response.getBody();
        log.info("Succes");
        for(MessageObject mess : result)
            System.out.println(mess);
    }

    public void incrementEntry(String name){
        uri = "http://localhost:8090/people/increment?name=" + name;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.PUT, null, new ParameterizedTypeReference<String>() {});
        String result = response.getBody();
        log.info(result);
    }

    public void getTop(String topNumber){
        uri = "http://localhost:8090/people/top?index=" + Integer.parseInt(topNumber);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Person>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>(){});
        List<Person> result = response.getBody();
        log.info("Succes");
        for(Person pers : result)
            System.out.println(pers.getName());
    }
}
