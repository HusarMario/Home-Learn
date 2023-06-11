import Game.Game;

import Game.Coordinates;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Game game = new Game();
        int difficulty = pickDifficulty();

        game.startGame(difficulty);

        while (true) {
            game.showGame();
            game.showGameDetails();
            Coordinates coordinates = pickCoordinates();
            if (!checkExit(coordinates)) {
                game.openModule(coordinates);
            } else break;
        }
    }

    static int pickDifficulty() {
        Scanner scanner = new Scanner(System.in);
        int difficulty;

        System.out.println("Welcome!");
        System.out.println("Pick difficulty");
        System.out.println("1. EASY");
        System.out.println("2. MEDIUM");
        System.out.println("3. HARD");

        do {
            difficulty = scanner.nextInt();
        } while (difficulty < 1 || difficulty > 3);

        return difficulty;
    }

    static Coordinates pickCoordinates() {
        Scanner scanner = new Scanner(System.in);

        int x;
        int y;

        System.out.println("Pick coordinates of module u wish to open next");
        System.out.println("If u wish to end choose x:0 or y:0");
        System.out.println("X:");
        do {
            x = scanner.nextInt();
        } while (x < 0);

        System.out.println("Y:");
        do {
            y = scanner.nextInt();
        } while (y < 0);

        return new Coordinates(x, y);
    }

    static boolean checkExit(Coordinates coordinates) {
        return coordinates.getX() == 0 || coordinates.getY() == 0;
    }
}



