package pieces;

import player.PlayerColor;

public class Piece {

    private Model model;
    private final PlayerColor color;
    private final PieceType type;
    private int x;
    private int y;

    public Piece(int x, int y, PlayerColor color, PieceType type) {
        this.color = color;
        this.type = type;
        this.createModel();
        this.moveModel(x,y);
        this.showModel();
    }

    private void createModel() {
        model = new Model(this.type, this.color);
    }

    public void moveModel(int x, int y) {
        this.model.center(x, y);
        this.x = x;
        this.y = y;
    }

    public void showModel() {
        this.model.show();
    }

    public void hideModel() {

    }

}
