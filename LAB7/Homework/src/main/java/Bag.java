import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> letters = new ArrayList<>();

    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            for(int numberOfDuplicate=0; numberOfDuplicate<10;numberOfDuplicate++){
                letters.add(new Tile(c));
            }
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        Random rand = new Random();
        int number;

        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            if(extracted.size()>howMany){
                break;
            }
            number = rand.nextInt(letters.size());
            extracted.add(letters.get(number));
            letters.remove(number);
        }
        return extracted;
    }

}
