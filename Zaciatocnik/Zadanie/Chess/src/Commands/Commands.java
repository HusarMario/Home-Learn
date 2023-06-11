package Commands;

import Piecees.*;


public class Commands implements CommandsInterface {

    private final Piece[][] board = new Piece[8][8];
    private final Piece[] store = new Piece[1];

    @Override
    public void startGame() {
        getBoard();
    }

    private void getBoard() {
        for (int i = 0; i < 8; i++) {
            if (i == 0 || i == 7)
                board[0][i] = new Rook(Colour.WHITE);
            if (i == 1 || i == 6)
                board[0][i] = new Horse(Colour.WHITE);
            if (i == 2 || i == 5)
                board[0][i] = new Bishop(Colour.WHITE);
            if (i == 3)
                board[0][i] = new King(Colour.WHITE);
            if (i == 4)
                board[0][i] = new Queen(Colour.WHITE);
        }

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Colour.WHITE);
        }

        for (int i = 0; i < 8; i++) {
            if (i == 0 || i == 7)
                board[7][i] = new Rook(Colour.BLACK);
            if (i == 1 || i == 6)
                board[7][i] = new Horse(Colour.BLACK);
            if (i == 2 || i == 5)
                board[7][i] = new Bishop(Colour.BLACK);
            if (i == 4)
                board[7][i] = new King(Colour.BLACK);
            if (i == 3)
                board[7][i] = new Queen(Colour.BLACK);
        }

        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(Colour.BLACK);
        }

        for(int j=2; j<6; j++)
            for (int i=0;i<8;i++)
                board[j][i] = new Piece();

    }

    @Override
    public void seeBoard() {
        for(int  i = -1; i < 9; i++)
            if(i==-1 || i==8)
                System.out.print("\u001B[36m" + (char) 176 + "\u001B[0m");
            else
                System.out.print("\u001B[36m" + (i+1) + "\u001B[0m");
        System.out.println();

        for (int i = 0; i < 8; i++) {
            for (int j = -1; j < 9; j++) {
                if(j==-1 || j==8)
                    System.out.print("\u001B[36m" + (i+1) + "\u001B[0m");
                else {
                    if (board[i][j].getType() == Type.DUMMY) {
                        if (board[i][j].isHighlight()) {
                            System.out.print("\u001B[31m" + (char) 176 + "\u001B[0m");
                        } else
                            System.out.print((char) 176);
                    } else if (board[i][j].getColour() == Colour.WHITE) {
                        if (board[i][j].isHighlight()) {
                            System.out.print("\u001B[31m" + board[i][j].getType().getShortcut() + "\u001B[0m");
                        } else
                            System.out.print("\u001B[30m" + board[i][j].getType().getShortcut() + "\u001B[0m");
                    } else if (board[i][j].getColour() == Colour.BLACK) {
                        if (board[i][j].isHighlight()) {
                            System.out.print("\u001B[31m" + board[i][j].getType().getShortcut() + "\u001B[0m");
                        } else
                            System.out.print("\u001B[35m" + board[i][j].getType().getShortcut() + "\u001B[0m");
                    }
                }

            }
            System.out.println();
        }


        for(int  i = -1; i < 9; i++){
            if(i==-1||i==8)
                System.out.print("\u001B[36m" + (char) 176 + "\u001B[0m");
            else
                System.out.print("\u001B[36m" + (i+1) + "\u001B[0m");
        }
        System.out.println();
        System.out.println();

    }

    @Override
    public boolean movePiece(int fromX, int fromY, int toX, int toY) {
        fromX--;
        fromY--;
        toX--;
        toY--;  // I GOT LAZY DONT ASK


        showHighLight((fromX+1),(fromY+1));

        if(board[toX][toY].isHighlight()){
            store[0] = board[toX][toY];
            board[toX][toY] = board[fromX][fromY];
            board[fromX][fromY] = new Piece();
            removeHighlight();

            if(checkOpeningKing(board[toX][toY].getColour())){
                removeHighlight();
                System.out.println("Ohrozil si krala");
                undoMove(fromX,fromY,toX,toY);
                return false;
            }

            removeHighlight();
            return true;
        }
        else
        {
            System.out.println("Neplatny pohyb figurkou");
            removeHighlight();
            return false;
        }
    }

    @Override
    public void seeMoves(int X, int Y){
        showHighLight(X,Y);
        seeBoard();
        removeHighlight();

    }

    private void showHighLight(int X, int Y) {
        X--;
        Y--;

        int help;


        switch (board[X][Y].getType()) {
            case DUMMY -> {
                System.out.println("No piece here");
            }
            case PAWN -> {
                switch (board[X][Y].getColour()) {
                    case WHITE -> {
                        if (X != 7) {
                            board[X + 1][Y].setHighlight(true);
                            if (X == 1)
                                board[X + 2][Y].setHighlight(true);
                            if (Y != 0)
                                if ((board[X + 1][Y - 1].getColour() != Colour.WHITE) && board[X + 1][Y - 1].getType() != Type.DUMMY)
                                    board[X + 1][Y - 1].setHighlight(true);
                            if (Y != 7)
                                if ((board[X + 1][Y + 1].getColour() != Colour.WHITE) && board[X + 1][Y + 1].getType() != Type.DUMMY)
                                    board[X + 1][Y + 1].setHighlight(true);
                        }
                    }
                    case BLACK -> {
                        if (X != 0) {
                            board[X - 1][Y].setHighlight(true);
                            if (X == 6)
                                board[X - 2][Y].setHighlight(true);
                            if (Y != 0)
                                if ((board[X - 1][Y - 1].getColour() != Colour.BLACK) && board[X - 1][Y - 1].getType() != Type.DUMMY)
                                    board[X - 1][Y - 1].setHighlight(true);
                            if (Y != 7)
                                if ((board[X - 1][Y + 1].getColour() != Colour.BLACK) && board[X - 1][Y + 1].getType() != Type.DUMMY)
                                    board[X - 1][Y + 1].setHighlight(true);
                        }
                    }
                }
            }
            case ROOK -> {
                if (X != 0) {
                    help = X - 1;
                    while (help > -1) {
                        if (board[help][Y].getType() == Type.DUMMY) {
                            board[help][Y].setHighlight(true);
                        } else {
                            if (board[help][Y].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[help][Y].setHighlight(true);
                                break;
                            }

                        }
                        help--;
                    }
                } //UP

                if (X != 7) {
                    help = X + 1;
                    while (help < 8) {
                        if (board[help][Y].getType() == Type.DUMMY) {
                            board[help][Y].setHighlight(true);
                        } else {
                            if (board[help][Y].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[help][Y].setHighlight(true);
                                break;
                            }
                        }
                        help++;
                    }
                } //DOWN

                if (Y != 0) {
                    help = Y - 1;
                    while (help > -1) {
                        if (board[X][help].getType() == Type.DUMMY) {
                            board[X][help].setHighlight(true);
                        } else {
                            if (board[X][help].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[X][help].setHighlight(true);
                                break;
                            }
                        }
                        help--;
                    }
                } //LEFT

                if (Y != 7) {
                    help = Y + 1;
                    while (help < 8) {
                        if (board[X][help].getType() == Type.DUMMY) {
                            board[X][help].setHighlight(true);
                        } else {
                            if (board[X][help].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[X][help].setHighlight(true);
                                break;
                            }
                        }
                        help++;
                    }
                } //RIGHT
            }
            case HORSE -> {
                if (X > 1) {
                    if (Y != 0)
                        if (board[X - 2][Y - 1].getColour() != board[X][Y].getColour())
                            board[X - 2][Y - 1].setHighlight(true);
                    if (Y != 7)
                        if (board[X - 2][Y + 1].getColour() != board[X][Y].getColour())
                            board[X - 2][Y + 1].setHighlight(true);
                } //UP

                if (X < 6) {
                    if (Y != 0)
                        if (board[X + 2][Y - 1].getColour() != board[X][Y].getColour())
                            board[X + 2][Y - 1].setHighlight(true);
                    if (Y != 7)
                        if (board[X + 2][Y + 1].getColour() != board[X][Y].getColour())
                            board[X + 2][Y + 1].setHighlight(true);
                } //DOWN

                if (Y < 6) {
                    if (X != 0)
                        if (board[X - 1][Y + 2].getColour() != board[X][Y].getColour())
                            board[X - 1][Y + 2].setHighlight(true);
                    if (X != 7)
                        if (board[X + 1][Y + 2].getColour() != board[X][Y].getColour())
                            board[X + 1][Y + 2].setHighlight(true);
                } //RIGHT

                if (Y > 1) {
                    if (X != 7)
                        if (board[X + 1][Y - 2].getColour() != board[X][Y].getColour())
                            board[X + 1][Y - 2].setHighlight(true);
                    if (X != 0)
                        if (board[X - 1][Y - 2].getColour() != board[X][Y].getColour())
                            board[X - 1][Y - 2].setHighlight(true);
                } //LEFT
            }
            case BISHOP -> {
                if (X != 0 && Y != 0) {
                    help = 1;
                    while ((X - help) > -1 && (Y - help) > -1) {
                        if (board[X - help][Y - help].getType() == Type.DUMMY) {
                            board[X - help][Y - help].setHighlight(true);
                        } else {
                            if (board[X - help][Y - help].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[X - help][Y - help].setHighlight(true);
                                break;
                            }
                        }
                        help++;
                    }
                } //UPLEFT

                if (X != 0 && Y != 7) {
                    help = 1;
                    while ((X - help) > -1 && (Y + help) < 8) {
                        if (board[X - help][Y + help].getType() == Type.DUMMY) {
                            board[X - help][Y + help].setHighlight(true);
                        } else {
                            if (board[X - help][Y + help].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[X - help][Y + help].setHighlight(true);
                                break;
                            }
                        }
                        help++;
                    }
                } //UPRIGHT

                if (X != 7 && Y != 0) {
                    help = 1;
                    while ((X + help) < 8 && (Y - help) > -1) {
                        if (board[X + help][Y - help].getType() == Type.DUMMY) {
                            board[X + help][Y - help].setHighlight(true);
                        } else {
                            if (board[X + help][Y - help].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[X + help][Y - help].setHighlight(true);
                                break;
                            }
                        }
                        help++;
                    }
                } //DOWNLEFT

                if (X != 7 && Y != 7) {
                    help = 1;
                    while ((X + help) < 8 && (Y + help) < 8) {
                        if (board[X + help][Y + help].getType() == Type.DUMMY) {
                            board[X + help][Y + help].setHighlight(true);
                        } else {
                            if (board[X + help][Y + help].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[X + help][Y + help].setHighlight(true);
                                break;
                            }
                        }
                        help++;
                    }
                } //UPRIGHT
            }
            case QUEEN -> {
                if (X != 0) {
                    help = X - 1;
                    while (help > -1) {
                        if (board[help][Y].getType() == Type.DUMMY) {
                            board[help][Y].setHighlight(true);
                        } else {
                            if (board[help][Y].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[help][Y].setHighlight(true);
                                break;
                            }

                        }
                        help--;
                    }
                } //UP

                if (X != 7) {
                    help = X + 1;
                    while (help < 8) {
                        if (board[help][Y].getType() == Type.DUMMY) {
                            board[help][Y].setHighlight(true);
                        } else {
                            if (board[help][Y].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[help][Y].setHighlight(true);
                                break;
                            }
                        }
                        help++;
                    }
                } //DOWN

                if (Y != 0) {
                    help = Y - 1;
                    while (help > -1) {
                        if (board[X][help].getType() == Type.DUMMY) {
                            board[X][help].setHighlight(true);
                        } else {
                            if (board[X][help].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[X][help].setHighlight(true);
                                break;
                            }
                        }
                        help--;
                    }
                } //LEFT

                if (Y != 7) {
                    help = Y + 1;
                    while (help < 8) {
                        if (board[X][help].getType() == Type.DUMMY) {
                            board[X][help].setHighlight(true);
                        } else {
                            if (board[X][help].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[X][help].setHighlight(true);
                                break;
                            }
                        }
                        help++;
                    }
                } //RIGHT

                if (X != 0 && Y != 0) {
                    help = 1;
                    while ((X - help) > -1 && (Y - help) > -1) {
                        if (board[X - help][Y - help].getType() == Type.DUMMY) {
                            board[X - help][Y - help].setHighlight(true);
                        } else {
                            if (board[X - help][Y - help].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[X - help][Y - help].setHighlight(true);
                                break;
                            }
                        }
                        help++;
                    }
                } //UPLEFT

                if (X != 0 && Y != 7) {
                    help = 1;
                    while ((X - help) > -1 && (Y + help) < 8) {
                        if (board[X - help][Y + help].getType() == Type.DUMMY) {
                            board[X - help][Y + help].setHighlight(true);
                        } else {
                            if (board[X - help][Y + help].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[X - help][Y + help].setHighlight(true);
                                break;
                            }
                        }
                        help++;
                    }
                } //UPRIGHT

                if (X != 7 && Y != 0) {
                    help = 1;
                    while ((X + help) < 8 && (Y - help) > -1) {
                        if (board[X + help][Y - help].getType() == Type.DUMMY) {
                            board[X + help][Y - help].setHighlight(true);
                        } else {
                            if (board[X + help][Y - help].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[X + help][Y - help].setHighlight(true);
                                break;
                            }
                        }
                        help++;
                    }
                } //DOWNLEFT

                if (X != 7 && Y != 7) {
                    help = 1;
                    while ((X + help) < 8 && (Y + help) < 8) {
                        if (board[X + help][Y + help].getType() == Type.DUMMY) {
                            board[X + help][Y + help].setHighlight(true);
                        } else {
                            if (board[X + help][Y + help].getColour() == board[X][Y].getColour()) {
                                break;
                            } else {
                                board[X + help][Y + help].setHighlight(true);
                                break;
                            }
                        }
                        help++;
                    }
                } //UPRIGHT

            }
            case KING -> {
                if (X != 0) {
                    help = X - 1;
                    if (board[help][Y].getColour() != board[X][Y].getColour())
                        board[help][Y].setHighlight(true);
                } //UP

                if (X != 7) {
                    help = X + 1;
                    if (board[help][Y].getColour() != board[X][Y].getColour())
                        board[help][Y].setHighlight(true);
                } //DOWN

                if (Y != 0) {
                    help = Y - 1;
                    if (board[X][help].getColour() != board[X][Y].getColour())
                        board[X][help].setHighlight(true);
                } //LEFT

                if (Y != 7) {
                    help = Y + 1;
                    if (board[X][help].getColour() != board[X][Y].getColour())
                        board[X][help].setHighlight(true);
                } //RIGHT

                if (X != 0 && Y != 0) {
                    help = 1;
                    if (board[X - help][Y - help].getColour() != board[X][Y].getColour())
                        board[X - help][Y - help].setHighlight(true);
                } //UPLEFT

                if (X != 0 && Y != 7) {
                    help = 1;
                    if (board[X - help][Y + help].getColour() != board[X][Y].getColour())
                        board[X - help][Y + help].setHighlight(true);
                } //UPRIGHT

                if (X != 7 && Y != 0) {
                    help = 1;
                    if (board[X + help][Y - help].getColour() != board[X][Y].getColour())
                        board[X + help][Y - help].setHighlight(true);
                } //DOWNLEFT

                if (X != 7 && Y != 7) {
                    help = 1;
                    if (board[X + help][Y + help].getColour() != board[X][Y].getColour())
                        board[X + help][Y + help].setHighlight(true);
                } //UPRIGHT
            }
        }
    }

    private void removeHighlight() {
        for(int j=0; j<8; j++)
            for (int i=0;i<8;i++)
                board[j][i].setHighlight(false);
    }

    @Override
    public boolean checkPiece(Colour player, int X, int Y) {
        X--;
        Y--;
        return board[X][Y].getColour() == player;
    }

    private void undoMove(int fromX, int fromY, int toX, int toY){
        board[fromX][fromY] = board[toX][toY];
        board[toX][toY] = store[0];
        removeHighlight();
    }

    @Override
    public boolean checkOpeningKing(Colour colour)
    {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j].getType() != Type.DUMMY)
                    if(board[i][j].getColour() != colour){
                        showHighLight(i+1,j+1);
                    }


            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j].getType() == Type.KING && board[i][j].getColour() == colour)
                    if (board[i][j].isHighlight())
                        return true;
            }
        }

        return false;
    }
}
