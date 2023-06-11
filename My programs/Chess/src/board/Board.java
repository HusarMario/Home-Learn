package board;

import pieces.PieceType;
import player.Player;
import tvary.*;

public class Board {
    static private final char[][] positions =
            {
                    {'R','H','B','Q','K','B','H','R'},
                    {'P','P','P','P','P','P','P','P'},
                    {' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' '},
                    {' ',' ',' ',' ',' ',' ',' ',' '},
                    {'P','P','P','P','P','P','P','P'},
                    {'R','H','B','K','Q','B','H','R'}
            };
    static private final Obdlznik background = new Obdlznik();
    static private final Square[][] board = new Square[8][8];
    private final Player player1;
    private final Player player2;

    public Board(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.createBackground();
        this.createBoard();
    }

    private void createBackground() {
        background.posunVodorovne(49);
        background.posunZvisle(49);
        background.zmenStrany(402,402);
        background.zmenFarbu("black");
        background.zobraz();
    }

    private void createBoard() {
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.createSquare(i,j);
                this.createPiece(i,j);
            }
        }
    }

    private void createSquare(int i, int j) {
        if((i + j) % 2 == 0) {
            board[i][j] = new Square("brown",(i+1)*50,(j+1)*50);
        } else {
            board[i][j] = new Square("blue",(i+1)*50,(j+1)*50);
        }
    }

    private void createPiece(int i, int j) {
        for (PieceType type : PieceType.values()) {
            if (type.getCharacter() == positions[j][i]) {
                if(j == 0 || j == 1) {
                    board[i][j].createPiece(type, this.player1.getColor());
                }

                if(j == 6 || j == 7) {
                    board[i][j].createPiece(type,this.player2.getColor());
                }
            }
        }
    }
}
