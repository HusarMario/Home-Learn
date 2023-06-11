package Heroes;

import Exceptions.NotEnoughEnergyException;

public class BlackWidow extends Hero{
    public BlackWidow() {
        this.hero = Heroes.BLACKWIDOW;

        this.health = 100;
        this.armor = 50;
        this.energy = 50;
        this.attack = 15;


    }

    @Override
    public void seeAttacks() {
        System.out.println("1 -> Punch (Energy:10,Distance:1)");
        System.out.println("2 -> Shoot Pistol (Energy:10,Distance:2-5)");
        System.out.println("3 -> LegNeck Snap (Energy:30,Distance:1)");
        System.out.println("4 -> Stun Braclets (Energy:50,Distance:2-5)");
        System.out.println("5 -> Dual Pistol (Energy:70,Distance:2-5)");
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
    public void thirdAttack(Hero enemy) throws Exception {
        int energy = 30;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        double pureAttack = (40) + Math.random()*15; //40-55

        if(enemy.armor < 0)
            enemy.armor = 0;

        double attack = pureAttack - (pureAttack/100*(enemy.armor));

        enemy.health = enemy.health-attack;
        enemy.armor = enemy.armor-pureAttack+attack;
        this.energy = this.energy - energy;
    }

    @Override
    public void fourthAttack(Hero enemy) throws Exception {
        int energy = 50;
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
        int energy = 70;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        double pureAttack = (attack*2) + Math.random()*this.attack; //30-45

        if(enemy.armor < 0)
            enemy.armor = 0;

        double attack = pureAttack - (pureAttack/100*(enemy.armor));

        enemy.health = enemy.health-attack-pureAttack;
        enemy.armor = enemy.armor-pureAttack+attack;
        this.energy = this.energy - energy;
    }
}
