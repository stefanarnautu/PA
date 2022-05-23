package db;

import entities.AlldataEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.BufferedReader;
import java.io.FileReader;

public class PopulateDatabase {

    public void populateTheDatabaseFromCsv(EntityManager entityManager, EntityTransaction transaction){
        String file = "./target/data/cities.csv";
        BufferedReader reader = null;
        String line = "";

        try{
          reader = new BufferedReader(new FileReader(file));

          int a=0;
          transaction.begin();

          AlldataEntity newEntity = new AlldataEntity();

          line = reader.readLine();//citesc headeru-ul

          while((line = reader.readLine()) != null){
              String[] row = line.split(",");

              newEntity.setId(Integer.parseInt(row[0]));
              newEntity.setName(row[1]);
              newEntity.setStateId(Integer.parseInt(row[2]));
              newEntity.setStateCode(row[3]);
              newEntity.setStateName(row[4]);
              newEntity.setCountryId(Integer.parseInt(row[5]));
              newEntity.setCountryCode(row[6]);
              newEntity.setCountryName(row[7]);
              newEntity.setLatitude(row[8]);
              newEntity.setLongitude(row[9]);
              newEntity.setWikidataid(row[10]);

              entityManager.merge(newEntity);
              System.out.println(a);
              a++;
          }

          transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
