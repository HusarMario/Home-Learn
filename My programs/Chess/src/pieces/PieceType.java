package pieces;

import tvary.Obdlznik;

public enum PieceType {
    PAWN('P'),
    KING('K'),
    QUEEN('Q'),
    ROOK('R'),
    KNIGHT('H'),
    BISHOP('B');

    private final char character;

    PieceType(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }
}
