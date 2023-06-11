public class RedUnit extends Unit{

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
