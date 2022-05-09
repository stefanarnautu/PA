package Objects;

import EntityManagerPK.EntityManagerClass;
import Repositories.AbstractRepo;
import Repositories.CitiesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class City extends AbstractRepo<CitiesEntity> {
    EntityManagerClass entityManagerClass = new EntityManagerClass();
    EntityManager entityManager = entityManagerClass.getEntityManager();
    EntityTransaction transaction = entityManagerClass.getTransaction();

    public void create(String country, String name,String latitude,String longitude){

        Object exists = entityManager.createNamedQuery("CitiesEntity.verify").setParameter(1,name).getSingleResult();

        if(Integer.parseInt(String.valueOf(exists))>0){
            System.out.println("Oras existent (" + name + ")");
        }
        else {
            CitiesEntity citiesEntity = new CitiesEntity();

            Integer lastId = (Integer) entityManager.createNamedQuery("CitiesEntity.getLastId").getResultStream().findFirst().get();

            citiesEntity.setId(lastId + 1);
            citiesEntity.setName(name);
            citiesEntity.setCapital("1");
            citiesEntity.setCountry(country);
            citiesEntity.setLatitude(latitude);
            citiesEntity.setLongitude(longitude);

            entityManager.persist(citiesEntity);
            transaction.commit();
        }
    }

    public CitiesEntity findByName(String name){
        CitiesEntity entityFouded = (CitiesEntity) entityManager
                .createNamedQuery("CitiesEntity.findByName")
                .setParameter("nameSearched",name)
                .getSingleResult();
        return entityFouded;
    }

    public String findById(int id){
        String entityFouded = (String) entityManager.createNativeQuery("select c.name from cities c where id=:idSearch")
                .setParameter("idSearch",id).getResultStream().findFirst().get();
        return entityFouded;
    }
}
