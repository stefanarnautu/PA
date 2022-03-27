package commands;

import objects.Catalog;
import objects.Item;

public class ListCommand {
    public void printAllItems(Catalog catalog){
        for(Item item : catalog.getItems()){
            item.toString();
        }
    }
}
