import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Bag {
    private final List<Tile> letters = new ArrayList<>();
    private boolean available = false;


    //constructorul citeste din fisier
    public Bag() {
        try {
            File myObj = new File("./target/instances/instance.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for(int numberOf=0;numberOf<Integer.parseInt(String.valueOf(data.charAt(2)));numberOf++) {
                    letters.add(new Tile(data.charAt(0)));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //da fiecarui jucator un numar de litere
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        Random rand = new Random();
        int number;

        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            if(extracted.size()>howMany){
                break;
            }
            number = rand.nextInt(letters.size());
            extracted.add(letters.get(number));
            letters.remove(number);
        }
        return extracted;
    }

    //adauga inapoi pe cele nefolosite
    public synchronized void addTileBack(List<Tile> reuse){
        for(Tile t : reuse){
            this.letters.add(t);
        }
        //System.out.println("Au ramas " + letters.size() + " litere.");
    }

}
