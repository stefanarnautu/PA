import java.util.Collections;
import java.util.Map;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Game game = new Game();
        game.addPlayer(new Player("Player1"));
        game.addPlayer(new Player("Player2"));
       /* game.addPlayer(new Player("Player3"));*/

        Thread daemon = new Thread(new Runnable() {
            public void run() {
                try {
                    sleep(5000);
                    System.out.println(game.getBoard().toString());

                    System.out.println("Jucatorul " + (Collections.max(game.getBoard().getPoint().entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey()) + " a castigat.");

                    System.exit(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemon.start();
        game.play();
    }
}
