import java.util.List;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running;
    public Player(String name) { this.name = name; }
    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }

        String word = String.valueOf(extracted.get(1).getLetter() + extracted.get(2).getLetter());

        game.getBoard().addWord(this, word);
        return true;
    }

    public boolean getName() {
      return true;
    }

    public void setGame(Game game) {
        this.game=game;
    }

    @Override
    public void run() {
        System.out.println(this.name);
    }
}
