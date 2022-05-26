package classes;

import entities.AlldataEntity;
import entities.CitiesEntity;
import entities.CountriesEntity;
import entities.StatesEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AddressCorrector {
    private String city;
    private String state;
    private String country;
    EntityManager entityManager;
    int stateId;
    int countryId;

    public AddressCorrector(String city, String state, String country, EntityManager entityManager) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.entityManager=entityManager;
    }
    public boolean VerifyCity()
    {
        boolean found = false;
        TypedQuery<CitiesEntity> query = this.entityManager.createNamedQuery("CitiesEntity.findAll", CitiesEntity.class);
        List<CitiesEntity> results = query.getResultList();
        //Object exists;
        for(CitiesEntity inst : results){
            if(this.city.equals(inst.getName()))
            {
                found=true;
                stateId=inst.getStateId();
            }
        }
        return found;
    }
    public boolean VerifyState()
    {
        boolean found = false;
        TypedQuery<StatesEntity> query = this.entityManager.createNamedQuery("StatesEntity.findByStateId", StatesEntity.class).setParameter("stateId", stateId);
        List<StatesEntity> results = query.getResultList();
        //Object exists;
        for(StatesEntity inst : results){
            if(this.state.equals(inst.getStateName()))
            {
                found=true;
                countryId=inst.getCountryId();
                //return;
            }
        }
        if(found==false)
        {
            for(StatesEntity inst : results){
                if(this.stateId==inst.getStateId())
                {
                    this.state=inst.getStateName();
                    countryId=inst.getCountryId();
                    //return;
                }
        }
    }
        return found;
    }
    public boolean VerifyCountry()
    {
        boolean found = false;
        TypedQuery<CountriesEntity> query = this.entityManager.createNamedQuery("CountriesEntity.findByCountryId", CountriesEntity.class).setParameter("countryId", countryId);
        List<CountriesEntity> results = query.getResultList();
        //Object exists;
        for(CountriesEntity inst : results){
            if(this.country.equals(inst.getCountryName()))
            {
                found=true;
                //return;
            }
        }
        if(found==false) {
            for (CountriesEntity inst : results) {
                if (this.countryId == inst.getCountryId()) {
                    this.country = inst.getCountryName();
                    //return;
                }
            }
        }

        return found;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
