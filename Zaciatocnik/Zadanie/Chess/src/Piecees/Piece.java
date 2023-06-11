package Piecees;

public class Piece {
    private Colour colour;
    protected Type type;
    private boolean highlight;

    public Piece(Colour colour) {
        this.colour = colour;
        this.highlight = false;
    }

    public Piece(){
        this.highlight = false;
        this.type = Type.DUMMY;
    }

    public Colour getColour() {
        return colour;
    }

    public Type getType() {
        return type;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public boolean isHighlight() {
        return highlight;
    }
}


