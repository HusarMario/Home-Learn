package Commands;

import Piecees.Colour;

public interface CommandsInterface {
    void startGame();
    void seeBoard();
    void seeMoves(int X,int Y);
    boolean movePiece(int fromX, int fromY, int toX, int toY);
    boolean checkPiece(Colour player, int X, int Y);
    boolean checkOpeningKing(Colour colour);
}
