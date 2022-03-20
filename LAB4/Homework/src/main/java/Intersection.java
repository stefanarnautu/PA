public class Intersection {
    private final String name;
    protected int numberOfStreets;

    public Intersection(String name){
        this.name=name;
        this.numberOfStreets=0;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "name='" + name + '\'' +
                '}';
    }
}
