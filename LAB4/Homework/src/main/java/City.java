import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class City {
    protected List<Street> strazileOrasului=new ArrayList<>();
    protected List<Intersection> intersectiileOrasului=new ArrayList<>();

    public City(List<Street> str, Set<Intersection> inter){
       strazileOrasului.addAll(str);
       intersectiileOrasului.addAll(inter);
    }

    public void streetsLongerThan(int length){
        strazileOrasului.stream()
                .filter(strada->strada.getLength()>=length)
                //.filter(strada->strada.intersectiiAdiacente.get(0).numberOfStreets + strada.intersectiiAdiacente.get(1).numberOfStreets>3)
                .filter(strada->strada.intersectiiAdiacente.get(0).numberOfStreets>3 && strada.intersectiiAdiacente.get(1).numberOfStreets>3)
                .forEach(str-> System.out.println(str.name));
    }
}
