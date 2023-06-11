public class Unit {
    protected int attack = 2;
    protected int health = 2;

    public Unit(){
    }

    public void showStats(){
        System.out.println(attack);
        System.out.println(health);
    }

    public void steady(){
        System.out.println("Unit has prepeared");
    }
}
