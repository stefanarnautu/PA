import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {


        Catalog catalog = new Catalog("Catalog");
        Item book1 = new Item("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", 1967, "Donald E. Knuth", "book");
        Item book2 = new Item("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", 2021, "James Gosling & others", "book");
        catalog.addItem(book1);
        catalog.addItem(book2);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File("target/item.json"), catalog);
        } catch (final Exception e) {
            e.printStackTrace();
        }

        Catalog catalogNou = new Catalog();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            catalogNou = objectMapper.readValue(new File("target/item.json"), Catalog.class);

        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (catalogNou != null) {
            for (Item item : catalogNou.getItems()) {
                System.out.println("title = " + item.getTitle());
            }
        }

        System.out.println(catalogNou.toString());
    }
}
