package Objects;

import EntytyManagerPK.EntityManagerClass;
import myClasses.ContinentsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Continent {
    EntityManagerClass entityManagerClass = new EntityManagerClass();
    EntityManager entityManager = entityManagerClass.getEntityManager();
    EntityTransaction transaction = entityManagerClass.getTransaction();

    public void create(String nume){
        Object exists = entityManager.createNamedQuery("ContinentsEntity.verify").setParameter(1,nume).getSingleResult();

        if(Integer.parseInt(String.valueOf(exists))>0){
            System.out.println("Continent existent (" + nume + ")");
        }
        else {
            ContinentsEntity continentsEntity = new ContinentsEntity();

            Integer lastId = (Integer) entityManager.createNamedQuery("ContinentsEntity.getLastId").getResultStream().findFirst().get();

            continentsEntity.setId(lastId + 1);
            continentsEntity.setName(nume);
            entityManager.persist(continentsEntity);
            transaction.commit();
        }
    }

    public Integer findByName(String name){
        int entityFouded = (int) entityManager
                .createNamedQuery("ContinentsEntity.findByName")
                .setParameter("nameSearched",name)
                .getResultStream()
                .findFirst()
                .get();
        return entityFouded;
    }

    public String findById(int id){
        String entityFouded = (String) entityManager.createNativeQuery("select c.name from continents c where id=:idSearch")
            .setParameter("idSearch",id).getResultStream().findFirst().get();
        return entityFouded;
    }
}
