package Objects;

import EntityManagerPK.EntityManagerClass;
import Repositories.AbstractRepo;
import Repositories.CitiesEntity;
import Repositories.CitieswithpopulationEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CityWithPopulation extends AbstractRepo<CitieswithpopulationEntity> {
    EntityManagerClass entityManagerClass = new EntityManagerClass();
    EntityManager entityManager = entityManagerClass.getEntityManager();
    EntityTransaction transaction = entityManagerClass.getTransaction();

    public void create(String country, String name,String latitude,String longitude,int population){

        Object exists = entityManager.createNamedQuery("CitieswithpopulationEntity.verify").setParameter(1,name).getSingleResult();

        if(Integer.parseInt(String.valueOf(exists))>0){
            System.out.println("Oras existent (" + name + ")");
        }
        else {
            CitieswithpopulationEntity citiesEntity = new CitieswithpopulationEntity();

            Integer lastId = (Integer) entityManager.createNamedQuery("CitieswithpopulationEntity.getLastId").getResultStream().findFirst().get();

            citiesEntity.setId(lastId + 1);
            citiesEntity.setName(name);
            citiesEntity.setCapital("1");
            citiesEntity.setCountry(country);
            citiesEntity.setLatitude(latitude);
            citiesEntity.setLongitude(longitude);
            citiesEntity.setPopulation(population);

            entityManager.persist(citiesEntity);
        }
    }

    public CitieswithpopulationEntity findByName(String name){
        CitieswithpopulationEntity entityFouded = (CitieswithpopulationEntity) entityManager
                .createNamedQuery("CitieswithpopulationEntity.findByName")
                .setParameter("nameSearched",name)
                .getSingleResult();
        return entityFouded;
    }

    public Long sumOfCityPopulationFromSameCountry(String name,int maxPopullation,int minPopulation){
        return (Long) entityManager
                .createNamedQuery("CitieswithpopulationEntity.citiesFromTheSameCountryPopolation")
                .setParameter("nameSearched",name)
                .setParameter("maxPopulation",maxPopullation)
                .setParameter("minPopulation",minPopulation)
                .getSingleResult();
    }

    public String findById(int id){
        String entityFouded = (String) entityManager.createNativeQuery("select c.name from CitiesWithPopulation c where id=:idSearch")
                .setParameter("idSearch",id).getResultStream().findFirst().get();
        return entityFouded;
    }
}
