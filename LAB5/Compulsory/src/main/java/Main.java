import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {

        Catalog catalog=new Catalog("C1");
        Item book1 = new Item("knuth67","The Art of Computer Programming", "d:/books/programming/tacp.ps", 1967, "Donald E. Knuth",  "book");
        Item book2 = new Item("java17","The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", 2021, "James Gosling & others","book");
        catalog.addItem(book1);
        catalog.addItem(book2);

        System.out.println(catalog);
        Main ma=new Main();
        //ma.testCreateSave(catalog);
    }

    private void testCreateSave(Catalog catalog) throws IOException {
        CatalogUtil.save(catalog, "D:\\a.FACULTATE\\PA\\PA\\LAB5\\Compulsory\\json\\catalog.json");
    }

}
