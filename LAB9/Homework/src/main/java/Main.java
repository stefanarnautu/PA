import EntytyManagerPK.EntityManagerClass;
import Repository.City;
import Repository.Continent;
import Repository.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {

        Continent continent = new Continent();
        Country country = new Country();
        City city = new City();

        EntityManagerClass entityManagerClass = new EntityManagerClass();

        EntityManagerFactory entityManagerFactory = entityManagerClass.getEntityManagerFactory();
        EntityManager entityManager = entityManagerClass.getEntityManager();
        EntityTransaction transaction = entityManagerClass.getTransaction();
        entityManagerClass.getTransaction().begin();
        try{
            continent.create("Australia");
            System.out.println("Id-ul continentului cu numele "+ continent.findById(1) +" este " + continent.findByName("Europe"));

            country.create("Romania","RO",continent.findByName("Europe"));
            System.out.println("Id-ul tarii cu numele "+ country.findById(1) +" este " + country.findByName("Romania"));

            city.create("Romania","Bucharest","44.43333333333333","26.1");
            System.out.println("Id-ul orasului cu numele "+ city.findById(175) +" este " + city.findByName("Bucharest"));

        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
