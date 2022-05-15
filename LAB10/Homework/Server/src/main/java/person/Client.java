package person;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private List<String> prieteni;

    public Client() {
        this.prieteni = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPrieteni() {
        return prieteni;
    }

    public void setPrieteni(String prieteni) {
        this.prieteni.add(prieteni);
    }
}
