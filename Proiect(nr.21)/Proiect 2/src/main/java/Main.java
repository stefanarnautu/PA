import classes.AddressCorrector;
import db.PopulateDatabase;
import entities.AlldataEntity;
import panel.MainFrame;

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
        //p.populateTables(entityManager,transaction);
        AddressCorrector addressCorrector = new AddressCorrector("Jurm","Badakhsh","Afghanist",entityManager);

        System.out.println("The inserted address is: City: "+addressCorrector.getCity()+" State: "+addressCorrector.getState()+" Country: "+addressCorrector.getCountry());
        if(addressCorrector.VerifyCity()==false)
        System.out.println("The inserted city doesn't exist!");
        addressCorrector.VerifyState();
        addressCorrector.VerifyCountry();

        System.out.println("The correct address is: City: "+addressCorrector.getCity()+" State: "+addressCorrector.getState()+" Country: "+addressCorrector.getCountry());
        new MainFrame().setVisible(true);
    }
}
