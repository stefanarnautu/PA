import db.PopulateDatabase;
import entities.AlldataEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        PopulateDatabase p = new PopulateDatabase();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        //Apelat doar la popularea bazei de date
        //p.populateTheDatabaseFromCsv(entityManager,transaction);

    }
}
