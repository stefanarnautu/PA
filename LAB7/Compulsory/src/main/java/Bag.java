import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> letters = new ArrayList<>();
    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            letters.add(new Tile(c));
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            Random rand = new Random();
            extracted.add(letters.get(rand.nextInt(letters.size())));
        }
        return extracted;
    }

}
