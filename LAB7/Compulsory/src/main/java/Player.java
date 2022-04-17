import java.util.List;
import java.util.Scanner;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running=true;
    private int points=0;

    public Player(String name) { this.name = name; }
    private void submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            running = false;
        }
        System.out.println(this.name);
        for(int letter=0;letter<extracted.size();letter++){
            System.out.print(extracted.get(letter).toString() + "    ");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a message" + this.name +": ");
        String message = scanner.nextLine();

        boolean ok=false;
        for(int wordLetter=0;wordLetter<message.length();wordLetter++){
            ok=false;
            for (Tile t: extracted) {
                if(t.getLetter() == message.charAt(wordLetter)) {
                    ok = true;
                    this.points+=t.getPoints();
                    break;
                }
            }
            if(ok==false){
                System.out.println("Cuvantul nu este formant din literele corespunzatoare("+this.name+")");
                break;
            }
            else{

                this.game.getBoard().addWord(this,message,this.points);
            }
        }

        while(!this.game.getDictionary().isWord(message))
        System.out.println();
    }
    public String getName() {
      return this.name;
    }

    public void setGame(Game game) {
        this.game=game;
    }

    @Override
    public void run() {
        while(this.running)
        this.submitWord();

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
