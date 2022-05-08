import EntytyManagerPK.EntityManagerClass;
import myClasses.ContinentsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {

        EntityManagerClass entityManagerClass = new EntityManagerClass();

        EntityManagerFactory entityManagerFactory = entityManagerClass.getEntityManagerFactory();
        EntityManager entityManager = entityManagerClass.getEntityManager();
        EntityTransaction transaction = entityManagerClass.getTransaction();
        try{
            transaction.begin();
            ContinentsEntity continentsEntity = new ContinentsEntity();
            continentsEntity.setId(101);
            continentsEntity.setName("Europa");
            entityManager.persist(continentsEntity);
            transaction.commit();
        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }


    }
}
