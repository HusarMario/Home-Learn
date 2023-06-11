package Heroes;

import Exceptions.GadgetEquipedException;
import Exceptions.GadgetNotEquipedException;
import Exceptions.NotEnoughEnergyException;
import Gadgets.CaptainAmericaShield;
import Gadgets.Gadget;
import Gadgets.Mjolnir;

public class CaptainAmerica extends Hero{

    public CaptainAmerica() {
        this.hero = Heroes.CAPTAINAMERICA;

        this.health = 125;
        this.armor = 75;
        this.energy = 50;
        this.attack = 25;

        gadgets = new Gadget[2];
        gadgets[0] = new CaptainAmericaShield();
        gadgets[1] = new Mjolnir();
    }

    @Override
    public void seeAttacks() {
        System.out.println("1 -> Punch (Energy:10,Distance:1)");
        System.out.println("2 -> Shoot Pistol (Energy:10,Distance:2-5)");
        System.out.println("3 -> Kick (Energy:30,Distance:1)");
        System.out.println("4 -> Throw Shield (Energy:50,Distance:2-5)");
        System.out.println("5 -> Summon Mjolnir (Energy:70)");
        super.seeAttacks();
    }


    @Override
    public void basicAttack(Hero enemy) throws Exception{
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
    public void rangeAttack(Hero enemy) throws Exception{
        int energy = 10;
        if(this.energy < energy){
            throw new NotEnoughEnergyException("Nemas dostatok energie");
        }

        double pureAttack = (attack-15) + Math.random()*this.attack; //10-35

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

        if(!gadgets[0].isActive()){
            throw new GadgetNotEquipedException("Nemozes pouzit predmet ktory nemas");
        }

        this.armor = this.armor - gadgets[0].getArmor();
        gadgets[0].setActive(false);
        if(this.armor < 0){
            this.armor = 0;
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
