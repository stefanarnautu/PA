import java.util.List;
import java.util.Scanner;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running=true;
    private int points=0;

    public Player(String name) { this.name = name; }
    private void submitWord() throws InterruptedException {

        List<Tile> extracted = game.getBag().extractTiles(7);

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
            System.out.println("\nWrite a message" + this.name + ": ");
            String message = scanner.nextLine();

            boolean ok, okTotal = true;
            for (int wordLetter = 0; wordLetter < message.length(); wordLetter++) {
                ok = false;
                for (Tile t : extracted) {
                    if (t.getLetter().compareTo(String.valueOf(message.charAt(wordLetter))) == 0) {
                        ok = true;
                        this.points += t.getPoints();
                        break;
                    }
                }
                if (ok == false) {
                    System.out.println("Cuvantul nu este formant din literele corespunzatoare(" + this.name + ")");
                    okTotal = false;
                    break;
                }
            }
            if (okTotal == true && message.length() > 0) {
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
                }
                this.game.getBoard().addWord(this, message, this.points);
            }

            game.getBag().addTileBack(extracted);
        }
        Thread.sleep(100);
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

        if(!running){
            System.out.println(this.name+" a castigat.");
            System.out.println(game.getBoard().toString());
        }

       /*
        while(running){
            this.submitWord();
        }

        if(!running) System.out.println("Win" + this.name);*/
    }
}
