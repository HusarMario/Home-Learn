import Commands.Commands;
import Piecees.Colour;
import Players.Player;

import java.util.Scanner;

public class Main {
    static private final Commands commands = new Commands();
    static void startGame(){
        commands.startGame();
    }
    static void seeMoves(int X,int Y){
        commands.seeMoves(X,Y);
    }
    static void seeBoard() {commands.seeBoard();}
    static boolean movePiece(int fromX,int fromY,int toX,int toY){
        return (commands.movePiece(fromX,fromY,toX,toY));
    }
    static boolean checkPiece(Colour player,int X,int Y){
        return (commands.checkPiece(player,X,Y));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Player player1 = new Player(Colour.WHITE);
        Player player2 = new Player(Colour.BLACK);
        Player player = player2;

        int Xfrom;
        int Yfrom;
        int Xto;
        int Yto;

        boolean rerun = false;
        boolean check = false;

        /*System.out.println("PRAVIDLA: ");
        System.out.println("Pre oznacenie figurky na zaciatku kola vyber jej suradnice.");
        System.out.println("Cervene zafarbenie oznacuje mozne tahy vybranou figurkou.");
        System.out.println("Pre zrusenie vybrania danej figurky vloz suradnice [0] [0].");
        System.out.println("Pre pohyb vybranou figurkou vyber suradnice pohybu");
        System.out.println("Hru je mozne opustit na zaciatku kazdeho kola vybratim suradnic [0] [0]");
        System.out.println("Ak chces zacat hrat stlac Y");*/

        /*char c = input.next().charAt(0);
        if(c == 'Y')*/
        startGame();

        /*System.out.print("Meno hraca cislo 1 : ");
        player1.setName(input.nextLine());

        System.out.print("Meno hraca cislo 2 : ");
        player2.setName(input.nextLine());*/


        while (true)
        {
            seeBoard();

            if(!rerun)
                player = switchPlayer(player,player1,player2);

            while (true){

                Xfrom = input.nextInt();
                Yfrom = input.nextInt();

                if(Xfrom == 0 && Yfrom == 0)
                    break;
                else if ((Xfrom < 9 && Xfrom > 0) && (Yfrom < 9 && Yfrom > 0)) {
                    if (checkPiece(player.getColour(), Xfrom, Yfrom)) {
                        seeMoves(Xfrom, Yfrom);
                        break;
                    }
                    else
                    {
                        System.out.println("Je potrebne oznacit figurku vlastnej farby");
                    }
                }
                else {
                    System.out.println("Hracie pole ma suradnice v rozmedzi od 1-8");
                }
            }

            if(Xfrom == 0 && Yfrom == 0)
                break;

            while (true) {

                Xto = input.nextInt();
                Yto = input.nextInt();

                if(Xto == 0 && Yto == 0){
                    rerun = true;
                    break;
                }
                else if ((Xto < 9 && Xto > 0) && (Yto < 9 && Yto > 0)) {
                    if (!checkPiece(player.getColour(), Xto, Yto)) {
                        if(movePiece(Xfrom, Yfrom, Xto, Yto))
                        {
                            rerun = false;

                            break;
                        }
                        else
                        {
                            rerun = true;
                            break;
                        }

                    }
                    else
                    {
                        System.out.println("Nesmies oznacit vlastnu figurku");
                    }
                }
                else {
                    System.out.println("Hracie pole ma suradnice v rozmedzi od 1-8");
                }
            }
        }


    }

    static Player switchPlayer(Player player, Player player1, Player player2){
        switch (player.getColour()){
            case WHITE -> {
                player = player2;
                System.out.println("Na tahu je " + player.getName() + " (cierny)");
            }

            case BLACK -> {
                player = player1;
                System.out.println("Na tahu je " + player.getName() + " (biely)");
            }
        }

        return player;
    }
}
