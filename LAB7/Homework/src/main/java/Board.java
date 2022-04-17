import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final List<String> words = new ArrayList<>();
    private final Map<String,Integer> point = new HashMap<>();
    public synchronized void addWord(Player player, String word,int points) {
        words.add(word);
        if(!point.containsKey(player.getName()))
        point.put(player.getName(),points);
        else point.replace(player.getName(),points);
        System.out.println("To dictionary: " + player.getName() + ": " + word);
    }

    @Override
    public String toString() {
        return "Board{" +
                "words=" + words +
                ", point=" + point +
                '}';
    }
}
