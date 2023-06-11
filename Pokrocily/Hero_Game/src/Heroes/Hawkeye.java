package Heroes;

import Exceptions.NotEnoughEnergyException;
import Gadgets.Bow;
import Gadgets.Gadget;
import Gadgets.Spear;

public class Hawkeye extends Hero{
    public Hawkeye() {
        this.hero = Heroes.HAWKEYE;

        this.health = 100;
        this.armor = 50;
        this.energy = 50;
        this.attack = 15;

        gadgets = new Gadget[2];
        gadgets[0] = new Bow();
        gadgets[1] = new Spear();

    }

    @Override
    public void seeAttacks() {
        System.out.print("Picked Weapon : ");
        if(gadgets[0].isActive())
            System.out.println("Bow");
        if(gadgets[1].isActive())
            System.out.println("Spear");
        System.out.println("1 -> Spear Attack (Energy:10,Distance:1)");
        System.out.println("2 -> Bow Attack (Energy:10,Distance:2-5)");
        System.out.println("3 -> Switch Weapon");
        System.out.println("4 -> StunArrow // StubSpear (Energy:30)");
        System.out.println("5 -> DoubleArrow Shot // Arrow Backstab (Energy:50)");
        super.seeAttacks();

    }

    @Override
    public void basicAttack(Hero enemy) throws Exception{
        int energy = 10;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        double pureAttack = (attack-5) + Math.random()*this.attack; //10-25

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

        double pureAttack = (attack*2) + Math.random()*this.attack; //30-45

        if(enemy.armor < 0)
            enemy.armor = 0;

        double attack = pureAttack - (pureAttack/100*(enemy.armor));

        enemy.health = enemy.health-attack;
        enemy.armor = enemy.armor-pureAttack+attack;
        this.energy = this.energy - energy;
    }

    @Override
    public void thirdAttack(Hero enemy){
        if(gadgets[0].isActive())
        {
            gadgets[0].setActive(false);
            gadgets[1].setActive(true);
        }

        if(gadgets[1].isActive())
        {
            gadgets[1].setActive(false);
            gadgets[0].setActive(true);
        }
    }

    @Override
    public void fourthAttack(Hero enemy) throws Exception {
        int energy = 30;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        double pureAttack = (15) + Math.random()*5; //15-20

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
        int energy = 50;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        if(gadgets[0].isActive()) {
            double pureAttack = (attack * 2) + Math.random() * this.attack; //30-45

            if (enemy.armor < 0)
                enemy.armor = 0;

            double attack = pureAttack - (pureAttack / 100 * (enemy.armor));

            enemy.health = enemy.health - attack - pureAttack;
            enemy.armor = enemy.armor - pureAttack + attack;
            this.energy = this.energy - energy;
        }

        if(gadgets[1].isActive()) {
            double pureAttack = (15) + Math.random()*15; //15-30

            enemy.health = enemy.health-pureAttack;
            this.energy = this.energy - energy;
        }
    }
}
