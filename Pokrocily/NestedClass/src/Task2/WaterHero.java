package Task2;

public class WaterHero extends Hero implements Commands{

    public WaterHero() {
    }

    @Override
    public void attack() {
        System.out.println("Water Attack");
    }

    @Override
    public void defense() {
        System.out.println("Water Defense");
    }

    @Override
    public void skipTurn() {
        System.out.println("Skipped Turn");
    }
}
