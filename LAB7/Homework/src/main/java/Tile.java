import java.util.Random;

public class Tile {
    private final char letter;
    private final int points;

    public Tile(char letter) {
        this.letter = letter;
        Random rand = new Random();
        this.points = rand.nextInt(9) + 1;
    }

    public char getLetter() {
        return letter;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return  letter +
                "-" + points;
    }
}
