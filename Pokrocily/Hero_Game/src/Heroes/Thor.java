package Heroes;

import Exceptions.GadgetEquipedException;
import Exceptions.NotEnoughEnergyException;
import Gadgets.Gadget;
import Gadgets.Stormbreaker;

public class Thor extends Hero{
    public Thor() {
        this.hero = Heroes.THOR;

        this.health = 125;
        this.armor = 50;
        this.energy = 50;
        this.attack = 30;

        gadgets = new Gadget[1];
        gadgets[0] = new Stormbreaker();
    }

    @Override
    public void seeAttacks() {
        System.out.println("1 -> Punch (Energy:10,Distance:1)");
        System.out.println("2 -> Throw Mjolnir (Energy:10,Distance:2-5)");
        System.out.println("3 -> Lightning Strike (Energy:30,Distance:2-5)");
        System.out.println("4 -> Spin Mjolnir (Energy:50,Distance:2-5)");
        System.out.println("5 -> Summon StormBreaker (Energy:70)");
        super.seeAttacks();
    }

    @Override
    public void basicAttack(Hero enemy) throws Exception{
        int energy = 10;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        double pureAttack = (attack-15) + Math.random()*this.attack;    //15-45

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

        double pureAttack = (attack-20) + Math.random()*this.attack; //10-40

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

        double pureAttack = (30) + Math.random()*10; //30-40

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
