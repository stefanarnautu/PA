import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean running = true;
    private int points=0;

    public Player(String name) { this.name = name; }

    //genereaza cuvantul cu literele trimise de functia de mai jos

    private synchronized String generateString(List<Tile> letters){
        Random r = new Random();
        String cuvant = "";

        int aCataLitera;
        int lungineCuvant = r.nextInt(letters.size());
        while (lungineCuvant < 2){
            lungineCuvant = r.nextInt(letters.size());
        }
        Integer vector[] = new Integer[10];
        for(int index=0; index<10;index++)
            vector[index] = 0;
        int incercari = 10;
        while(incercari>0) {
            for (int l = 0; l < lungineCuvant; l++) {
                aCataLitera = r.nextInt(letters.size());

                while (vector[aCataLitera] == 1)
                    aCataLitera = r.nextInt(letters.size());

                cuvant += String.valueOf(letters.get(aCataLitera).getLetter());
                vector[aCataLitera] = 1;
            }
            if(this.game.getDictionary().isWord(cuvant)){
                incercari = 0;
            }
            else {
                incercari--;
                for(int index=0; index<10;index++)
                    vector[index] = 0;
                cuvant = "";
            }

        }
        return cuvant;
    }

    //genereaza cuvant,
    //verifica daca exista prin apelare dictionar,
    //adauga in board punctaj si cuvant
    //pune literele inapoi

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
            System.out.println(this.name+" a castigat prin terminarea tuturor literelor.");
            return;
        }
        System.out.println();
        for(int letter=0;letter<extracted.size();letter++){
            System.out.print(extracted.get(letter).getLetter());
        }
        System.out.println();

        String wordGenerate;


        synchronized (this) {
            wordGenerate = generateString(extracted);

            if (wordGenerate.length() > 0) {
                if (this.game.getDictionary().isWord(wordGenerate)) {
                    boolean ok = false;
                    for (int wordLetter = 0; wordLetter < wordGenerate.length(); wordLetter++) {
                        for (Tile t : extracted) {
                            if (t.getLetter().compareTo(String.valueOf(wordGenerate.charAt(wordLetter))) == 0) {
                                this.points += t.getPoints();
                                extracted.remove(t);
                                break;
                            }
                        }
                    }
                    game.getBag().addTileBack(extracted);
                    this.game.getBoard().addWord(this, wordGenerate, this.points);
                    System.out.println(this.name + " are " + this.points + " puncte.");
                } else  {
                    System.out.println("Cuvantul " + wordGenerate + " nu exista in dictionar.(" + this.name + ")");
                    this.game.getBag().addTileBack(extractedInitial);
                }
            }else this.game.getBag().addTileBack(extractedInitial);
            sleep(50);
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
    }
}
