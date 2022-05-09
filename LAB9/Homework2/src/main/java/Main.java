import EntityManagerPK.EntityManagerClass;
import Objects.City;
import Objects.CityWithPopulation;
import Objects.Continent;
import Objects.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {

        Continent continent = new Continent();
        Country country = new Country();
        City city = new City();
        CityWithPopulation newCity = new CityWithPopulation();

        EntityManagerClass entityManagerClass = new EntityManagerClass();

        EntityManagerFactory entityManagerFactory = entityManagerClass.getEntityManagerFactory();
        EntityManager entityManager = entityManagerClass.getEntityManager();
        EntityTransaction transaction = entityManagerClass.getTransaction();
        entityManagerClass.getTransaction().begin();
        try{

           /* for(int contor=1;contor<=238;contor++){
                      System.out.println(newCity.findByName(newCity.findById(contor)));
                  /*  int minVal = 10000;
                    int maxVal = 1000000;
                    ThreadLocalRandom tlr = ThreadLocalRandom.current();
                    int randomNum = tlr.nextInt(minVal, maxVal + 1);

                    newCity.findByName(newCity.findById(contor)).setPopulation(randomNum);

            }*/

            System.out.println(city.findByName("Bucharest"));
            System.out.println(continent.findByName("Europe"));
            System.out.println(newCity.findByName("Bucharest"));
            System.out.println(country.findByName("Romania"));

           /* city.create("Romania","Buchare","44.43333333333333","26.1");
            newCity.create("Romania","Neamt","44.43333333333333","26.1",200000);
            newCity.create("Romania","Iasi","44.43333333333333","26.1",800000);
            newCity.create("Romania","Cluj-Napoca","44.43333333333333","26.1",350000);
            newCity.create("Romania","Timisoara","44.43333333333333","26.1",490000);*/

            System.out.println("Orasul "+ city.findById(175) +" are urmatoarele date " + city.findByName("Bucharest"));
            System.out.println(newCity.sumOfCityPopulationFromSameCountry("Romania",10000000,10000));
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
