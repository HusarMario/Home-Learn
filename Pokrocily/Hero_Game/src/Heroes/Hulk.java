package Heroes;

import Exceptions.NotEnoughEnergyException;

public class Hulk extends Hero{

    public Hulk() {
        this.hero = Heroes.HULK;

        this.health = 200;
        this.armor = 0;
        this.energy = 50;
        this.attack = 50;
    }

    @Override
    public void seeAttacks() {
        System.out.println("1 -> SMASH (Energy:15,Distance:1)");
        System.out.println("2 -> JUMP (Energy:30,Distance:2-5)");
        System.out.println("3 -> ROAR");
        System.out.println("4 -> THROW (Energy:50,Distance:1)");
        System.out.println("5 -> PUNYGOD (Energy:70,Distance:1)");
        super.seeAttacks();
    }

    @Override
    public void basicAttack(Hero enemy) throws Exception {
        int energy = 10;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        double pureAttack = (attack-20) + Math.random()*this.attack;    //30-80

        if(enemy.armor < 0)
            enemy.armor = 0;

        double attack = pureAttack - (pureAttack/100*(enemy.armor));

        enemy.health = enemy.health-attack;
        enemy.armor = enemy.armor-pureAttack+attack;
        this.energy = this.energy - energy;
    }

    @Override
    public void rangeAttack(Hero enemy,int distance) throws Exception{
        int energy = 30;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        double pureAttack = (5*distance) + Math.random()*this.attack; //0-50

        if(enemy.armor < 0)
            enemy.armor = 0;

        double attack = pureAttack - (pureAttack/100*(enemy.armor));

        enemy.health = enemy.health-attack;
        enemy.armor = enemy.armor-pureAttack+attack;
        this.energy = this.energy - energy;
    }

    @Override
    public void thirdAttack(Hero enemy) {
        this.energy = energy + 25;
    }

    @Override
    public void fourthAttack(Hero enemy) throws Exception {
        int energy = 50;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        double pureAttack = (20) + Math.random()*10; //20-30

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

        double pureAttack = (attack*2) + Math.random()*this.attack; //100-150

        if(enemy.armor < 0)
            enemy.armor = 0;

        double attack = pureAttack - (pureAttack/100*(enemy.armor));

        enemy.health = enemy.health-attack-pureAttack;
        enemy.armor = enemy.armor-pureAttack+attack;
        this.energy = this.energy - energy;
    }
}
