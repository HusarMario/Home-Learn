package Task2;

public class FireHero extends Hero implements Commands{

    public FireHero() {
    }

    @Override
    public void attack() {
        System.out.println("Fire Attack");
    }

    @Override
    public void defense() {
        System.out.println("Fire Defense");
    }

    @Override
    public void skipTurn() {
        System.out.println("Skipped Turn");
    }
}
