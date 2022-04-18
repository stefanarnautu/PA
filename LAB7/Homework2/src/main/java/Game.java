import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Game {
    private final Bag bag = new Bag();
    private final Board board = new Board();
    private final MockDictionary dictionary = new MockDictionary();
    private final List<Player> players = new ArrayList<>();
    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }
    public void play() throws InterruptedException {
        for (Player player : players){
             new Thread(player).start();
             sleep(100);
        }
    }

    public synchronized Board getBoard() {
        return board;
    }

    public synchronized Bag getBag() {
        return bag;
    }

    public synchronized MockDictionary getDictionary(){
        return dictionary;
    }
}
