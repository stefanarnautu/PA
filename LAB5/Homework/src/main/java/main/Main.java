package main;

import commands.LoadData;
import commands.ReportCommand;
import commands.SaveData;
import commands.ViewCommand;
import objects.Item;
import objects.Catalog;

public class Main{
    public static void main(String[] args){
        Catalog catalog = LoadData.load("target/catalog.json");
        if (catalog != null) {
            for (Item item : catalog.getItems()) {
                System.out.println("title = " + item.getTitle());

            }
        }
        ViewCommand.view(catalog.getItems().get(0));
        ViewCommand.view(catalog.getItems().get(1));
        ReportCommand.view(catalog);
        System.out.println(catalog.toString());
        SaveData.save(catalog,"target/catalog.json");
    }
}
