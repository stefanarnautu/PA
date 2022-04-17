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
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public Bag getBag() {
        return bag;
    }

    public MockDictionary getDictionary(){
        return dictionary;
    }
}
