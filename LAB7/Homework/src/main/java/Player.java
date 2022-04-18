import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running = true;
    private int points=0;

    public Player(String name) { this.name = name; }
    private synchronized void submitWord() throws InterruptedException {

        try {
            sleep((int) (Math.random() * 1000));
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        List<Tile> extracted = game.getBag().extractTiles(7);
        List<Tile> extractedInitial = new ArrayList<>();

        extractedInitial.addAll(extracted);

        if (extracted.isEmpty()) {
            running = false;
            return;
        }
        System.out.println();
        for(int letter=0;letter<extracted.size();letter++){
            System.out.print(extracted.get(letter).toString() + "    ");
        }
        synchronized (this) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nFormeaza un cuvant cu literele de mai sus " + this.name + ": ");
            String message = scanner.nextLine();
            boolean ok, okTotal = true;
            for (int wordLetter = 0; wordLetter < message.length(); wordLetter++) {
                ok = false;
                for (Tile t : extracted) {
                    if (t.getLetter().compareTo(String.valueOf(message.charAt(wordLetter))) == 0) {
                        ok = true;
                        this.points += t.getPoints();
                        extracted.remove(t);
                        break;
                    }
                }
                if (ok == false) {
                    System.out.println("Cuvantul nu este formant din literele corespunzatoare(" + this.name + ")");
                    okTotal = false;
                    game.getBag().addTileBack(extractedInitial);
                    break;
                }
            }

            if (okTotal == true && message.length() > 0) {
                if (this.game.getDictionary().isWord(message)) {
                    game.getBag().addTileBack(extracted);
                    this.game.getBoard().addWord(this, message, this.points);
                    System.out.println(this.name + " are " + this.points + " puncte.");
                } else  System.out.println("Cuvantul nu exista in dictionar.(" + this.name + ")");
            }
            sleep(100);
        }

    }

    public String getName() {
        return this.name;
    }

    public void setGame(Game game) {
        this.game=game;
    }

    @Override
    public void run() {
        while(this.running) {
            try {
                this.submitWord();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(this.name+" a castigat.");
        System.out.println(game.getBoard().toString());
    }
}
