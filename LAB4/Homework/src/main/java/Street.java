import java.util.ArrayList;
import java.util.List;

public class Street{
    protected String name;
    private Integer lengthOf;
    protected List<Intersection> intersectiiAdiacente=new ArrayList<>();
    protected int intersectia1;
    protected int intersectia2;
    public Street(String name, int length,Intersection intersection1,Intersection intersection2,int intersectia1,int intersectia2){
        this.name=name;
        this.lengthOf=length;
        this.intersectiiAdiacente.add(intersection1);
        this.intersectiiAdiacente.add(intersection2);
        this.intersectia1=intersectia1;
        this.intersectia2=intersectia2;
        intersection1.numberOfStreets++;
        intersection2.numberOfStreets++;
    }

    public int getLength() {
        return lengthOf;
    }

    public static int compareByLength(Street str1, Street str2) {
        return str1.lengthOf.compareTo(str2.getLength());
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + lengthOf +
                ", intersectiiAdiacente=" + intersectiiAdiacente +
                '}';
    }

}

