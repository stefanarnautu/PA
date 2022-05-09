package Repository;

import EntytyManagerPK.EntityManagerClass;
import myClasses.CitiesEntity;

import javax.persistence.EntityManager;

public abstract class GenericRepo <T> {
    EntityManagerClass entityManagerClass = new EntityManagerClass();
    EntityManager entityManager = entityManagerClass.getEntityManager();

    public T findById(int id){
        return (T) entityManager.createNativeQuery("select c from cities c where id=:idSearch")
                .setParameter("idSearch",id).getSingleResult();
    }

}
