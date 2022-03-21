import java.util.ArrayList;
import java.util.List;

public class Catalog implements IManagmentCatalog{
    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog(String name){
        this.name=name;
    }

    public void addItem(Item item){
        items.add(item);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
