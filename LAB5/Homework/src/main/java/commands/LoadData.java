package commands;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import objects.Catalog;

public class LoadData {
    public static Catalog load(String path){
        Catalog catalog = new Catalog();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            catalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (StreamReadException e) {
            System.out.println("Stream Read Exception:\n" + e);
        } catch (DatabindException e) {
            System.out.println("Databind Exception:\n" + e);
        } catch (IOException e) {
            System.out.println("IO Exception:\n" + e);
        }

        return catalog;
    }
}
