import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

public class CatalogUtil {
    public static void save(Catalog catalog, String path){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File("target/item.json"), catalog);
        } catch (final Exception e) {
            System.out.println("Error at write: " + e);
        }
    }

    public static Catalog load(String path){
        Catalog catalog = new Catalog();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            catalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (StreamReadException e) {
            System.out.println("Stream Read Exception: " + e);
            //e.printStackTrace();
        } catch (DatabindException e) {
            System.out.println("Databind Exception: " + e);
        } catch (IOException e) {
            System.out.println("IO Exception at: " + e);
        }
      return catalog;
    }
}
