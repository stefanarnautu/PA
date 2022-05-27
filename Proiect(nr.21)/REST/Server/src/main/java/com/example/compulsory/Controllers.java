package com.example.compulsory;
import classes.AddressCorrector;
import org.springframework.web.bind.annotation.*;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/addresses")
public class Controllers {
    AddressCorrector address;

    @PostMapping("/verify")
    public String create(@RequestParam String country, @RequestParam String state, @RequestParam String city) {
        String tara,stat,oras;
        String response="";
        boolean next = true;
        if (city.length()==0 || state.length()==0 || country.length()==0) {
            response = "This is an empty field!";
            next = false;
        }
        if (next) {
            oras = city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase(Locale.ROOT);
            stat = state.substring(0, 1).toUpperCase() + state.substring(1).toLowerCase(Locale.ROOT);
            tara = country.substring(0, 1).toUpperCase() + country.substring(1).toLowerCase(Locale.ROOT);
            this.address = new AddressCorrector(tara,stat,oras);
            System.out.println(this.address);
            if (!this.address.verifyCountry()) {
                if(!this.address.verifyStateByName()){
                    if(!this.address.verifyCityByName()){
                       response = "Nothing from this address can be found in the database!";

                    }else{
                        this.address.setStateName();
                        this.address.setCountryName();
                        response = "City: " + this.address.getCity() + " State: " + this.address.getState() + " Country: " + this.address.getCountry();
                    }
                }else{
                    this.address.setCountryName();
                    response = "City: " + this.address.getCity() + " State: " + this.address.getState() + " Country: " + this.address.getCountry();
                }
            } else if (!this.address.verifyState()) {
                if (!this.address.verifyCityByName()) {
                    response = "The city and the state doesn't exist!";
                } else {
                    this.address.setStateName();
                    response = "City: " + this.address.getCity() + " State: " + this.address.getState() + " Country: " + this.address.getCountry();
                }

            } else if (!this.address.verifyCity()) {
                response = "City doesn't exist!";
            } else {
                response = "Address is correct " + this.address.getCity() + " " + this.address.getState() + " " + this.address.getCountry();
            }
        }
        return response;
    }

}
