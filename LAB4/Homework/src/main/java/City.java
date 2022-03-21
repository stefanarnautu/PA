import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Aceasta clasa retine o instanta a problemei (strazile si intersesctiile dintr-un oras)
 */
public class City {
    protected List<Street> strazileOrasului=new ArrayList<>();
    protected List<Intersection> intersectiileOrasului=new ArrayList<>();

    /**
     * Constructorul
     * @param str primeste o lista de strazi
     * @param inter primeste o lista de intersectii
     */
    public City(List<Street> str, Set<Intersection> inter){
       strazileOrasului.addAll(str);
       intersectiileOrasului.addAll(inter);
    }

    /**
     * O functie de foloseste o interogare (cu ajutorul lui steam()) pentru a afisa acele strazi care sunt mai lungi decat o valoare data
     * si care intersecteaza la ambele capete alte 3 strazi
     * @param length lungimea minima
     */
    public void streetsLongerThan(int length){
        strazileOrasului.stream()
                .filter(strada->strada.getLength()>=length)
                //.filter(strada->strada.intersectiiAdiacente.get(0).numberOfStreets + strada.intersectiiAdiacente.get(1).numberOfStreets>3)
                .filter(strada->strada.intersectiiAdiacente.get(0).numberOfStreets>3 && strada.intersectiiAdiacente.get(1).numberOfStreets>3)
                .forEach(str-> System.out.println(str.name));
    }
}
