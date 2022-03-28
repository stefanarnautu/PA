package commands;

import objects.Catalog;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReportCommand {
    public static void view(Catalog catalog){
        try{
            File htmlFile = new File("D:/a.FACULTATE/PA/PA/LAB5/Homework/src/main/resources/prezentareCatalog.html");
            Desktop.getDesktop().browse(htmlFile.toURI());

        } catch(IOException e) {
            System.out.println("IO Exception:\n" + e);
        }
    }
}
