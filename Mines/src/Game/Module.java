package Game;

public class Module {
    private boolean mine;
    private boolean mark;
    private boolean open;
    private int numMines;

    protected Module() {
        this.mine = false;
        this.open = false;
        this.mark = false;
        this.numMines = 0;
    }

    protected int getNumMines() {
        return numMines;
    }

    protected boolean isMine() {
        return mine;
    }

    protected boolean isOpen() {
        return open;
    }

    protected void setMine() {
        this.mine = true;
    }

    protected void setNumMines(){
        this.numMines++;
    }

    protected void setOpen(){
        this.open = true;
    }

    protected void resetModule(){
        this.mine = false;
        this.open = false;
        this.mark = false;
        this.numMines = 0;
    }



}


