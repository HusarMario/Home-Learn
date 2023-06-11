public class Main {

    public static void main(String[] args) {

        char[][] map = new char[8][10];
        map[0] = new char[]{'O', 'X', 'X', 'O', 'O','O', 'X', 'X', 'O', 'O'};
        map[1] = new char[]{'X', 'X', 'X', 'O', 'O','O', 'X', 'X', 'O', 'O'};
        map[2] = new char[]{'O', 'O', 'X', 'X', 'X','O', 'X', 'X', 'O', 'O'};
        map[3] = new char[]{'O', 'O', 'O', 'X', 'X','O', 'X', 'X', 'O', 'O'};
        map[4] = new char[]{'O', 'O', 'O', 'O', 'O','O', 'X', 'X', 'O', 'O'};
        map[5] = new char[]{'O', 'X', 'X', 'O', 'O','O', 'X', 'X', 'O', 'O'};
        map[6] = new char[]{'X', 'X', 'X', 'O', 'O','O', 'X', 'X', 'O', 'O'};
        map[7] = new char[]{'O', 'O', 'X', 'X', 'X','O', 'X', 'X', 'O', 'O'};

        char[][] house = new char[2][2];
        house[0] = new char[]{'H', 'H'};
        house[1] = new char[]{'H', '-'};

        int maxXmap = map.length;
        int maxYmap = map[0].length;

        for (int x = 0; x < maxXmap-1; x++) {
            for (int y = 0; y < maxYmap-1; y++) {
                {
                    if((map[x][y]=='X'&&house[0][0]=='H')||(house[0][0]=='-'))  //Zaklad
                        if((map[x][y+1]=='X'&&house[0][1]=='H')||(house[0][1]=='-')) //Doprava
                            if((map[x+1][y]=='X'&&house[1][0]=='H')||(house[1][0]=='-')) //Dole
                                if((map[x+1][y+1]=='X'&&house[1][1]=='H')||(house[1][1]=='-')) //Dole vpravo
                                    System.out.println(map[x][y]+""+x+""+y);

                }
            }
        }
    }
}


