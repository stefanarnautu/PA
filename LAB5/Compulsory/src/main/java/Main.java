public class Main{
    public static void main(String[] args) {


        Catalog catalog = new Catalog("Catalog");
        Item book1 = new Item("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", 1967, "Donald E. Knuth", "book");
        Item book2 = new Item("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", 2021, "James Gosling & others", "book");
        catalog.addItem(book1);
        catalog.addItem(book2);

        CatalogUtil.save(catalog,"target/item.json");
        Catalog catalogNou =  CatalogUtil.load("target/item.json");

        if (catalogNou != null) {
            for (Item item : catalogNou.getItems()) {
                System.out.println("title = " + item.getTitle());
            }
        }

        System.out.println(catalogNou.toString());
    }
}
