package Repository;

import EntytyManagerPK.EntityManagerClass;
import myClasses.ContinentsEntity;
import myClasses.CountriesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;

public class Country {
    EntityManagerClass entityManagerClass = new EntityManagerClass();
    EntityManager entityManager = entityManagerClass.getEntityManager();
    EntityTransaction transaction = entityManagerClass.getTransaction();

    public void create(String nume,String code,int continentId){

        Object exists = entityManager.createNamedQuery("CountriesEntity.verify").setParameter(1,nume).getSingleResult();

        if(Integer.parseInt(String.valueOf(exists))>0){
            System.out.println("Tara existenta (" + nume + ")");
        }
        else {
            CountriesEntity countriesEntity = new CountriesEntity();

            Integer lastId = (Integer) entityManager.createNamedQuery("CountriesEntity.getLastId").getResultStream().findFirst().get();

            countriesEntity.setId(lastId + 1);
            countriesEntity.setName(nume);
            countriesEntity.setCode(code);
            countriesEntity.setContinent(continentId);

            entityManager.persist(countriesEntity);
            transaction.commit();
        }
    }

    public Integer findByName(String name){
        return (Integer) entityManager
                .createNamedQuery("CountriesEntity.findByName")
                .setParameter("nameSearched",name).getResultStream().findFirst().get();
    }

    public String findById(int id){
        String entityFouded = (String) entityManager.createNativeQuery("select c.name from countries c where id=:idSearch")
                .setParameter("idSearch",id).getResultStream().findFirst().get();
        return entityFouded;
    }
    
    public CountriesEntity returnCountry(Integer id){
        return (CountriesEntity) entityManager
                .createNamedQuery("CountriesEntity.findObjectByName")
                .setParameter("idSearched",id)
                .getSingleResult();
    }
}
