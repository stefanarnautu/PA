package commands;
import objects.Catalog;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand {
    public static void view(String path){
        Desktop desktop = Desktop.getDesktop();
        try{
            desktop.open(new File(path));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}
