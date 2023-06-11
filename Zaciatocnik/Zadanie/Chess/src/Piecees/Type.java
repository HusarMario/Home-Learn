    package Piecees;

public enum Type {
    KING("K"),
    QUEEN("Q"),
    ROOK("R"),
    BISHOP("B"),
    HORSE("H"),
    PAWN("P"),
    DUMMY("░");


    private final String shortcut;

    private Type(String shortcut){
        this.shortcut = shortcut;
    }

    public String getShortcut() {
        return shortcut;
    }
}
