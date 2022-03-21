public class Item{
    protected String id;
    protected String title;
    protected String location;
    protected int year;
    protected String author;
    protected String type;

    public Item(String id, String title, String location, int year, String author, String type){
        this.id=id;
        this.title=title;
        this.location=location;
        this.year=year;
        this.author=author;
        this.type=type;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
