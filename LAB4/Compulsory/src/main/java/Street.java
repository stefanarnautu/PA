import java.util.HashMap;
import java.util.Map;

public class Street {
    protected String name;
    protected int length;
   /*
    protected Intersection first=new Intersection();
    protected Intersection second=new Intersection();
   */
    protected Map<Integer,String> intersectiiAdiacente=new HashMap<>();

    public Street(String name, int length,Intersection intersection1,Intersection intersection2){
        this.name=name;
        this.length=length;
        this.intersectiiAdiacente.put(1,intersection1.getName());
        this.intersectiiAdiacente.put(2,intersection2.getName());
    }
}
