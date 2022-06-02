package com.example.compulsory;

import EntityManagerPK.EntityManagerClass;
import data.AccountsEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@RestController
public class controllers {

    List<AccountsEntity> accounts = new ArrayList<>();

    EntityManagerClass entityManagerClass = new EntityManagerClass();
    EntityManager entityManager = entityManagerClass.getEntityManager();
    EntityTransaction transaction = entityManagerClass.getTransaction();

    @RequestMapping("/hello")
    public String sayHello() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/people")
    public List getProducts() {
        accounts.addAll(entityManager.createQuery(
                        "SELECT c FROM AccountsEntity c")
                .getResultList());
        System.out.println(accounts.toString());
        return entityManager.createQuery(
                          "SELECT c FROM AccountsEntity c")
                            .getResultList();
    }
    @PostMapping("/login")
    public ResponseEntity<String> createProduct(@RequestParam String name) {

        int id = 1 + Integer.parseInt(entityManager.createQuery(
                "SELECT count(*) FROM AccountsEntity").getSingleResult().toString());
        transaction.begin();
        AccountsEntity newAccount = new AccountsEntity();
        newAccount.setId(id);
        newAccount.setName(name);
        entityManager.merge(newAccount);
        transaction.commit();
        return new ResponseEntity<>(
                "Updated successsfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestParam String name) {
        transaction.begin();
        entityManager.createQuery(
                        "UPDATE AccountsEntity \n" +
                                "    SET name = :name\n" +
                                "    WHERE id = :id").setParameter("name",name).setParameter("id",id).executeUpdate();

        transaction.commit();

        return new ResponseEntity<>(
                "Updated successsfully", HttpStatus.OK);
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

    @GetMapping("/people/count")
    public int countProducts() {
        return accounts.size();
    }

}
