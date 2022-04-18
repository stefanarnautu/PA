public class Main {
    public static void main(String args[]) throws InterruptedException {
        Game game = new Game();
        game.addPlayer(new Player("Player1"));
      /*  game.addPlayer(new Player("Player2"));
        game.addPlayer(new Player("Player3"));*/
        game.play();
    }
}
