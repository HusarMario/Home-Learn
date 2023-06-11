package Heroes;

import Gadgets.Gadget;

public abstract class Hero {
    protected Heroes hero;
    protected double health;
    protected double energy;
    protected double armor;
    protected double attack;

    protected boolean stun = false;
    protected Gadget[] gadgets;



    public int moveTowards(int distance){
        return distance-1;
    }

    public int moveBackwards(int distance){
        return distance+1;
    }

    public void basicAttack(Hero enemy) throws Exception{

    }

    public void rangeAttack(Hero enemy) throws Exception{

    }

    public void rangeAttack(Hero enemy,int distance) throws Exception{

    }

    public void thirdAttack(Hero enemy) throws Exception{

    }

    public void fourthAttack(Hero enemy) throws Exception{

    }

    public void fifthAttack(Hero enemy) throws Exception{

    }

    public void seeStats(){
        System.out.printf("Hero : %s%n",hero);
        System.out.printf("Health : %.2f%n ",health);
        System.out.printf("Armor : %.2f%n",armor);
        System.out.printf("Energy : %.2f%n",energy);
        System.out.printf("Attack : %.2f%n",attack);
        System.out.println();
    }

    public void seeAttacks(){
        System.out.println("6 -> Move to enemy");
        System.out.println("7 -> Move away from enemy");

    }

    public Heroes getHero() {
        return hero;
    }

    public double getHealth() {
        return health;
    }

    public double getEnergy() {
        return energy;
    }

    public Gadget[] getGadgets() {
        return gadgets;
    }

    public boolean isStun() {
        return stun;
    }

    public void gainEnergy(double energy) {
        this.energy = this.energy + energy;
    }

    public void removeStun(){
        stun = false;
    }


}
