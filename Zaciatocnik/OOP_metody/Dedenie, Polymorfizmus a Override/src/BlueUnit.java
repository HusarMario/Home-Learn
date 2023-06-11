public class BlueUnit extends Unit{

    public BlueUnit() {
        super();
        this.health = 3;
        this.attack = 1;
    }

    @Override
    public void steady() {
        super.steady();
        attack = attack + 1;
    }
}
