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
          int cont;
          while((line = reader.readLine()) != null){
              String[] row = line.split(",");
              cont=0;
              newEntity.setId(Integer.parseInt(row[cont]));
              cont++;
              if(row[cont].startsWith("\"") && !row[cont].endsWith("\"")){
                  newEntity.setName(row[cont] + row[cont+1]);
                  cont+=2;
              }else{
                  newEntity.setName(row[cont]);
                  cont++;
              }
              newEntity.setStateId(Integer.parseInt(row[cont]));
              cont++;
              newEntity.setStateCode(row[cont]);
              cont++;
              if(row[cont].startsWith("\"") && !row[cont].endsWith("\"")){
                  newEntity.setStateName(row[cont] + row[cont+1]);
                  cont+=2;
              }else{
                  newEntity.setStateName(row[cont]);
                  cont++;
              }
              newEntity.setCountryId(Integer.parseInt(row[cont]));
              cont++;
              newEntity.setCountryCode(row[cont]);
              cont++;
              if(row[cont].startsWith("\"") && !row[cont].endsWith("\"")){
                  newEntity.setCountryName(row[cont] + row[cont+1]);
                  cont+=2;
              }else{
                  newEntity.setCountryName(row[cont]);
                  cont++;
              }
              newEntity.setLatitude(row[cont]);
              cont++;
              newEntity.setLongitude(row[cont]);
              cont++;
              if(row.length>cont)
              newEntity.setWikidataid(row[cont]);
              else newEntity.setWikidataid("none");
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
