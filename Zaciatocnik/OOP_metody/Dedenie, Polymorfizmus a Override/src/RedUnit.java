public class RedUnit extends Unit{

    public RedUnit() {
        super();
        this.health = 1;
        this.attack = 3;
    }

    @Override
    public void steady() {
        super.steady();
        health = health + 1;
    }
}
