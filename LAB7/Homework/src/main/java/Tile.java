import java.util.Locale;

public class Tile {
    private final String letter;
    private final int points;

    public Tile(char letter) {
        this.letter = String.valueOf(letter).toLowerCase(Locale.ROOT);

        String point1 = "aeioulnstr";
        String point2 = "dg";
        String point3 = "bcmp";
        String point4 = "fhvwy";
        String point5 = "k";
        String point8 = "jx";
        String point10 = "qz";
        if(point1.contains(this.letter.toLowerCase(Locale.ROOT))){
            points = 1;
        }else if(point2.contains(this.letter.toLowerCase(Locale.ROOT))){
            points = 2;
        }else if(point3.contains(this.letter.toLowerCase(Locale.ROOT))){
            points = 3;
        }else if(point4.contains(this.letter.toLowerCase(Locale.ROOT))){
            points = 4;
        }else if(point5.contains(this.letter.toLowerCase(Locale.ROOT))){
            points = 5;
        }else if(point8.contains(this.letter.toLowerCase(Locale.ROOT))){
            points = 8;
        }else if(point10.contains(this.letter.toLowerCase(Locale.ROOT))){
            points = 10;
        } else points=0;
    }

    public String getLetter() {
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
