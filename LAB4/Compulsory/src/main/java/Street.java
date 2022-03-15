import java.util.HashMap;
import java.util.Map;

public class Street{
    protected String name;
    protected Integer lengthOf;
    protected Map<Integer,String> intersectiiAdiacente=new HashMap<>();

    public Street(String name, int length,Intersection intersection1,Intersection intersection2){
        this.name=name;
        this.lengthOf=length;
        this.intersectiiAdiacente.put(1,intersection1.getName());
        this.intersectiiAdiacente.put(2,intersection2.getName());
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

