import Exceptions.*;
import Game.Commands;
import Game.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        
        Scanner scanner = new Scanner(System.in);
        Commands commands = new Commands();
        commands.createGame();

        System.out.print("Zadajte meno prveho hraca: ");
        Player player1 = new Player(scanner.nextLine());
        commands.showHeroes();
        do {
            try {
                commands.pickHeroes(player1, scanner.nextInt());
                break;
            } catch (PickRightHeroException | InputMismatchException exception) {
                exception.printStackTrace();
                scanner.nextLine();
            }
        } while (true);

        scanner.nextLine();
        System.out.println();

        System.out.print("Zadajte meno druheho hraca: ");
        Player player2 = new Player(scanner.nextLine());
        commands.showHeroes();
        do {
            try {
                commands.pickHeroes(player2, scanner.nextInt());
                break;
            } catch (PickRightHeroException | AlreadyPickedHeroException | InputMismatchException exception) {
                exception.printStackTrace();
                scanner.nextLine();
            }
        } while (true);


        System.out.println();

        commands.presentPlayers(player1,player2);
        commands.addRoles(player1,player2);

        while (commands.aliveHeroes(player1,player2)){
            commands.gainEnergy();
            commands.switchRoles();
            commands.checkStunned();
            commands.showRoles();

            commands.showAttacks();

            do{
                try{
                    commands.chooseAttack(scanner.nextInt());
                    break;
                } catch (PickBadAttackException | TooCloseException | TooFarException
                        | NotEnoughEnergyException | GadgetNotEquipedException | InputMismatchException exception){
                    exception.printStackTrace();
                    scanner.nextLine();
                }
            } while (true);

            commands.showScore();
        }




    }
}
