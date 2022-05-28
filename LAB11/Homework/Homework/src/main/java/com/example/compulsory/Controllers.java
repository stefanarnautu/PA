package com.example.compulsory;

import EntityManagerPK.EntityManagerClass;
import data.AccountsEntity;
import data.MessagesEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/people")
public class Controllers {

    List<AccountsEntity> accounts = new ArrayList<>();

    EntityManagerClass entityManagerClass = new EntityManagerClass();
    EntityManager entityManager = entityManagerClass.getEntityManager();
    EntityTransaction transaction = entityManagerClass.getTransaction();

    @RequestMapping("/hello")
    public String sayHello() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/all")
    public List<AccountsEntity> getPersons() {
        accounts.addAll(entityManager.createQuery(
                        "SELECT c FROM AccountsEntity c")
                .getResultList());
        return entityManager.createQuery(
                          "SELECT c FROM AccountsEntity c")
                            .getResultList();
    }

    @PostMapping("/register")
    public ResponseEntity<String> createPerson(@RequestParam String name) {
        int id = 1 + Integer.parseInt(entityManager.createQuery(
                "SELECT count(*) FROM AccountsEntity").getSingleResult().toString());
        transaction.begin();
        AccountsEntity newAccount = new AccountsEntity();
        newAccount.setId(id);
        newAccount.setName(name);
        newAccount.setEntries(1);
        entityManager.merge(newAccount);
        transaction.commit();
        return new ResponseEntity<>(
                "Updated successsfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable int id, @RequestParam String name) {
        transaction.begin();
        entityManager.createQuery(
                        "UPDATE AccountsEntity \n" +
                                "    SET name = :name\n" +
                                "    WHERE id = :id").setParameter("name",name).setParameter("id",id).executeUpdate();

        transaction.commit();

        return new ResponseEntity<>(
                "Updated successsfully", HttpStatus.OK);
    }

    @PutMapping("/increment")
    public ResponseEntity<String> updatePersonEntry(@RequestParam String name) {
        transaction.begin();
        int lastNumberOfEntry = (int) entityManager.createQuery("select entries from AccountsEntity where name=:name")
                                             .setParameter("name",name).getSingleResult() + 1;
        entityManager.createQuery(
                "UPDATE AccountsEntity \n" +
                        "    SET entries = :entry\n" +
                        "    WHERE name = :name")
                     .setParameter("entry",lastNumberOfEntry)
                     .setParameter("name",name)
                     .executeUpdate();
        transaction.commit();

        return new ResponseEntity<>(
                name + " has logged in  " + lastNumberOfEntry + " times.", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        AccountsEntity account = (AccountsEntity) entityManager.createQuery("select c from AccountsEntity c where id=:id").setParameter("id",id).getSingleResult();
        if (account == null) {
            return new ResponseEntity<>(
                    "Account not found", HttpStatus.GONE);
        }
        transaction.begin();
        entityManager.remove(account);
        transaction.commit();
        return new ResponseEntity<>("Account removed", HttpStatus.OK);
    }

    @PostMapping("/messages/write")
    public ResponseEntity<String> writeMessage(@RequestParam String name,@RequestParam String message) {
        int id = 1 + Integer.parseInt(entityManager.createQuery(
                "SELECT count(*) FROM MessagesEntity").getSingleResult().toString());
        transaction.begin();
        MessagesEntity newMessage = new MessagesEntity();
        newMessage.setId(id);
        newMessage.setName(name);
        newMessage.setMessage(message);
        entityManager.merge(newMessage);
        transaction.commit();
        return new ResponseEntity<>(
                "Message wrote", HttpStatus.OK);
    }
    @GetMapping("/messages/get")
    public List<MessagesEntity> getMessages() {
        return entityManager.createQuery(
                        "SELECT c FROM MessagesEntity c")
                .getResultList();
    }

    @GetMapping("/top")
    public List<AccountsEntity> getTop(@RequestParam int index) {
        return entityManager.createQuery(
                        "SELECT c FROM AccountsEntity c order by entries desc")
                .getResultList().subList(0,index>5 ? 5 : index);
    }


    @GetMapping("/count")
    public int countProducts() {
        return accounts.size();
    }

}
