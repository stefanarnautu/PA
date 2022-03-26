import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Catalog.class),
})
public class Catalog implements IManagmentCatalog, Serializable {
    private String name;
    private List<Item> items = new ArrayList<>();


    public Catalog(String name, List<Item> items){
        this.name=name;
        this.items.addAll(items);
    }

    public Catalog(){
        this.name=null;
        this.items=null;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Catalog{" + "name='" + name + '\'' + ", items=" + items + '}';
    }
    @JsonCreator
    public Catalog(@JsonProperty("name")String name) {
        this.name= String.valueOf(name);

    }
}
