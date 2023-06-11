package Heroes;

import Exceptions.GadgetEquipedException;
import Exceptions.NotEnoughEnergyException;
import Gadgets.Gadget;
import Gadgets.Hulkbuster;

public class IronMan extends Hero{

    public IronMan() {
        this.hero = Heroes.IRONMAN;

        this.health = 50;
        this.armor = 100;
        this.energy = 50;
        this.attack = 25;

        gadgets = new Gadget[1];
        gadgets[0] = new Hulkbuster();
    }

    @Override
    public void seeAttacks() {
        System.out.println("1 -> Punch (Energy:10,Distance:1)");
        System.out.println("2 -> Repulsor Shot (Energy:10,Distance:2-5)");
        System.out.println("3 -> LaserBeam (Energy:30,Distance:2-5)");
        System.out.println("4 -> HandCanon (Energy:50,Distance:2-5)");
        System.out.println("5 -> HulkBuster (Energy:70)");
        super.seeAttacks();
    }

    @Override
    public void basicAttack(Hero enemy) throws Exception{
        int energy = 10;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        double pureAttack = (attack-10) + Math.random()*this.attack;  //15-40

        if(enemy.armor < 0)
            enemy.armor = 0;

        double attack = pureAttack - (pureAttack/100*(enemy.armor));

        enemy.health = enemy.health-attack;
        enemy.armor = enemy.armor-pureAttack+attack;
        this.energy = this.energy - energy;
    }

    @Override
    public void rangeAttack(Hero enemy) throws Exception{
        int energy = 10;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        double pureAttack = (attack) + Math.random()*this.attack; //25-50

        if(enemy.armor < 0)
            enemy.armor = 0;

        double attack = pureAttack - (pureAttack/100*(enemy.armor));

        enemy.health = enemy.health-attack;
        enemy.armor = enemy.armor-pureAttack+attack;
        this.energy = this.energy - energy;
    }

    @Override
    public void thirdAttack(Hero enemy) throws Exception {
        int energy = 30;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        double pureAttack = (15) + Math.random()*15; //15-30

        enemy.health = enemy.health-pureAttack;
        this.energy = this.energy - energy;
    }

    @Override
    public void fourthAttack(Hero enemy) throws Exception {
        int energy = 50;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        double pureAttack = (25) + Math.random()*5; //25-30

        if(enemy.armor < 0)
            enemy.armor = 0;

        double attack = pureAttack - (pureAttack/100*(enemy.armor));

        enemy.health = enemy.health-attack;
        enemy.armor = enemy.armor-pureAttack+attack;
        this.energy = this.energy - energy;
        enemy.stun = true;
    }

    @Override
    public void fifthAttack(Hero enemy) throws Exception {
        int energy = 70;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        if(gadgets[1].isActive()){
            throw new GadgetEquipedException("Nemozes pouzit znova tento predmet");
        }

        this.health = this.health + gadgets[1].getHealth();
        this.attack = this.attack + gadgets[1].getAttack();
        gadgets[1].setActive(true);
    }
}
