package commands;

import objects.Item;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ViewCommand {
    public static void view(Item item){
        try{
            URI uriul = new URI(item.getLocation());
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(uriul);

        } catch(IOException e) {
            System.out.println("IO Exception:\n" + e);
        } catch (URISyntaxException e) {
            System.out.println("URI Exception:\n" + e);
        } catch (Exception e){
            File newFile = new File(item.getLocation());
            Desktop desktop = Desktop.getDesktop();
            try{
                desktop.open(newFile);
            } catch (IOException eNew) {
                System.out.println("IO Exception (is not a file):\n" + e);
            }

        }
    }

}
