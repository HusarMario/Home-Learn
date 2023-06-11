public class BlueUnit extends Unit{

    public BlueUnit() {
        this.health = 3;
        this.attack = 1;
    }

    @Override
    public void showStats() {
        System.out.println(health);
        System.out.println(attack);
    }

    @Override
    public void steady() {
        attack = attack + 1;
    }
}
