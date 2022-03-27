package objects;

import com.fasterxml.jackson.annotation.*;
import interfaces.AddElement;
import interfaces.IManagmentCatalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Catalog.class),
})

public class Catalog implements IManagmentCatalog, Serializable, AddElement {
    private String name;
    private List<Item> items = new ArrayList<>();


    public Catalog(String name, List<Item> items){
        this.name=name;
        this.items.addAll(items);
    }

    public Catalog(){
    }

    public void addItem(Item newItem){
        items.add(newItem);
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
