package Game;

import java.util.Random;

public class Game {
    private Module [][] map;
    private int mapsize;
    private int numMines;

    public void startGame(int difficulty){
        setDifficulty(difficulty);
        createMap();
        insertMines();
        insertNumbers();
    }

    private void setDifficulty(int difficulty){
        switch (difficulty) {
            case 1 -> {
                mapsize = 5;
                numMines = 5;
            }
            case 2 -> {
                mapsize = 10;
                numMines = 25;
            }
            case 3 -> {
                mapsize = 15;
                numMines = 75;
            }
        }
    }

    private void createMap(){
        map = new Module[mapsize][mapsize];

        for(int i = 0;i<mapsize;i++) {
            for (int j = 0; j<mapsize; j++) {
                map[i][j]=new Module();
            }
        }
    }

    private void resetMap(){
        for(int i = 0;i<mapsize;i++) {
            for (int j = 0; j<mapsize; j++) {
                map[i][j].resetModule();
            }
        }
    }

    private void insertMines(){
        Random random = new Random();
        int mines = 0;

        while(mines != numMines)
        {
            for(int i = 0;i<mapsize;i++) {
                for (int j = 0; j<mapsize; j++) {
                    if((!map[i][j].isMine())&&(mines<numMines)&&(random.nextInt(10)==1)) {
                        map[i][j].setMine();
                        mines++;
                    }
                }
            }
        }
    }

    private void insertNumbers(){
        for(int i = 0;i<mapsize;i++) {
            for (int j = 0; j<mapsize; j++) {
                if(!map[i][j].isMine()) {
                    if (i == 0) {
                        if (j == 0) {
                            if(map[i][j+1].isMine())
                                map[i][j].setNumMines();
                            if(map[i+1][j].isMine())
                                map[i][j].setNumMines();
                            if(map[i+1][j+1].isMine())
                                map[i][j].setNumMines();

                        } else if (j == mapsize - 1) {
                            if(map[i][j-1].isMine())
                                map[i][j].setNumMines();
                            if(map[i+1][j-1].isMine())
                                map[i][j].setNumMines();
                            if(map[i+1][j].isMine())
                                map[i][j].setNumMines();
                        } else {
                            if(map[i][j-1].isMine())
                                map[i][j].setNumMines();
                            if(map[i][j+1].isMine())
                                map[i][j].setNumMines();
                            if(map[i+1][j-1].isMine())
                                map[i][j].setNumMines();
                            if(map[i+1][j].isMine())
                                map[i][j].setNumMines();
                            if(map[i+1][j+1].isMine())
                                map[i][j].setNumMines();
                        }
                    } else if (i == mapsize - 1) {
                        if (j == 0) {
                            if(map[i-1][j].isMine())
                                map[i][j].setNumMines();
                            if(map[i-1][j+1].isMine())
                                map[i][j].setNumMines();
                            if(map[i][j+1].isMine())
                                map[i][j].setNumMines();
                        } else if (j == mapsize - 1) {
                            if(map[i-1][j-1].isMine())
                                map[i][j].setNumMines();
                            if(map[i-1][j].isMine())
                                map[i][j].setNumMines();
                            if(map[i][j-1].isMine())
                                map[i][j].setNumMines();
                        } else {
                            if(map[i-1][j-1].isMine())
                                map[i][j].setNumMines();
                            if(map[i-1][j].isMine())
                                map[i][j].setNumMines();
                            if(map[i-1][j+1].isMine())
                                map[i][j].setNumMines();
                            if(map[i][j-1].isMine())
                                map[i][j].setNumMines();
                            if(map[i][j+1].isMine())
                                map[i][j].setNumMines();
                        }
                    } else if (j == 0) {
                        if(map[i-1][j].isMine())
                            map[i][j].setNumMines();
                        if(map[i-1][j+1].isMine())
                            map[i][j].setNumMines();
                        if(map[i][j+1].isMine())
                            map[i][j].setNumMines();
                        if(map[i+1][j].isMine())
                            map[i][j].setNumMines();
                        if(map[i+1][j+1].isMine())
                            map[i][j].setNumMines();
                        }
                     else if (j == mapsize - 1) {
                        if(map[i-1][j-1].isMine())
                            map[i][j].setNumMines();
                        if(map[i-1][j].isMine())
                            map[i][j].setNumMines();
                        if(map[i][j-1].isMine())
                            map[i][j].setNumMines();
                        if(map[i+1][j-1].isMine())
                            map[i][j].setNumMines();
                        if(map[i+1][j].isMine())
                            map[i][j].setNumMines();
                    } else {
                        if(map[i-1][j-1].isMine())
                            map[i][j].setNumMines();
                        if(map[i-1][j].isMine())
                            map[i][j].setNumMines();
                        if(map[i-1][j+1].isMine())
                            map[i][j].setNumMines();
                        if(map[i][j-1].isMine())
                            map[i][j].setNumMines();
                        if(map[i][j+1].isMine())
                            map[i][j].setNumMines();
                        if(map[i+1][j-1].isMine())
                            map[i][j].setNumMines();
                        if(map[i+1][j].isMine())
                            map[i][j].setNumMines();
                        if(map[i+1][j+1].isMine())
                            map[i][j].setNumMines();
                    }
                }

            }
        }

    }

    public void showGameDetails(){
        /* Rozhranie */
        System.out.print("     ");
        for(int i = 0;i<mapsize;i++) {
            if(i<9)
                System.out.print("\u001B[35m" + (i+1) + "  " + "\033[0m");
            else
                System.out.print("\u001B[35m" + (i+1) + " " + "\033[0m");
        }
        System.out.println();
        System.out.println();
        /* Rozhranie */
        for(int i = 0;i<mapsize;i++) {
            for (int j = 0; j<mapsize; j++) {
                /* Rozhranie */
                if(j==0){
                    if(i<9)
                        System.out.print("\u001B[35m" + (i+1) + "  " + "\033[0m");
                    else
                        System.out.print("\u001B[35m" + (i+1) + " " + "\033[0m");
                }
                if(map[i][j].isMine()){
                    System.out.print("\033[0;31m" + "  " + "M" + "\033[0m");
                }
                else {
                    System.out.print( "\033[0;34m" + "  " + map[i][j].getNumMines() + "\033[0m");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void showGame(){
        /* Rozhranie */
        System.out.print("     ");
        for(int i = 0;i<mapsize;i++) {
            if(i<9)
                System.out.print("\u001B[35m" + (i+1) + "  " + "\033[0m");
            else
                System.out.print("\u001B[35m" + (i+1) + " " + "\033[0m");
        }
        System.out.println();
        System.out.println();
        /* Rozhranie */
        for(int i = 0;i<mapsize;i++) {
            for (int j = 0; j<mapsize; j++) {
                /* Rozhranie */
                if(j==0){
                    if(i<9)
                        System.out.print("\u001B[35m" + (i+1) + "  " + "\033[0m");
                    else
                        System.out.print("\u001B[35m" + (i+1) + " " + "\033[0m");
                }
                /* Rozhranie */
                if (map[i][j].isOpen()) {
                    if (map[i][j].isMine()) {
                        System.out.print("\033[0;31m" + "  " + "M" + "\033[0m");
                    } else {
                        System.out.print("\033[0;34m" + "  " + map[i][j].getNumMines() + "\033[0m");
                    }
                } else System.out.print("  " + "X");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void openModule(Coordinates coordinates){
        map[coordinates.getY()-1][coordinates.getX()-1].setOpen();
    }




}
