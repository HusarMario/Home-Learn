package board;

import pieces.Piece;
import pieces.PieceType;
import player.PlayerColor;
import tvary.Obdlznik;

class Square {
    private final Obdlznik model = new Obdlznik();
    private final String color;
    private final int x;
    private final int y;
    private Piece piece;

    Square(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.createModel();
    }

    private void createModel() {
        model.posunVodorovne(this.x);
        model.posunZvisle(this.y);
        model.zmenStrany(50,50);
        model.zmenFarbu(color);
        model.zobraz();
    }

    public void createPiece(PieceType type, PlayerColor color) {
        this.piece = new Piece(this.x, this.y, color, type);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
