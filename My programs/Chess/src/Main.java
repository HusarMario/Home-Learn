import board.Board;
import player.Player;
import player.PlayerColor;
import tvary.Obdlznik;

public class Main {

    public static void main(String[] args) {
        Game game = new Game(new Player("Prvy", PlayerColor.RED),new Player("Druhy",PlayerColor.WHITE));
    }
}
