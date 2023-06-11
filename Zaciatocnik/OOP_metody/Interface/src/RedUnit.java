public class RedUnit implements Unit{

    protected int attack = 2;
    protected int health = 2;

    public RedUnit() {
        this.health = 1;
        this.attack = 3;
    }

    @Override
    public void showStats() {
        System.out.println(health);
        System.out.println(attack);
    }

    @Override
    public void steady() {
        health = health + 1;
    }
}
