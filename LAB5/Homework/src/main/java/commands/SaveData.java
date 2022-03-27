package commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;

public class SaveData {
    public static void save(Object catalog, String path){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File(path), catalog);
        } catch (final Exception e) {
            System.out.println("Error at write: " + e);
        }
    }
}
