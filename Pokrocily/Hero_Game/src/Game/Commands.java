package Game;

import Exceptions.*;
import Heroes.*;

public class Commands implements CommandsInterface{

    private final Hero[] listOfHeroes = new Hero[6];
    private int pickedHeroNum = 0;
    private int distance = 3;
    Player attacker;
    Player defender;

    @Override
    public void createGame() {
        listOfHeroes[0] = new CaptainAmerica();
        listOfHeroes[1] = new IronMan();
        listOfHeroes[2] = new BlackWidow();
        listOfHeroes[3] = new Hawkeye();
        listOfHeroes[4] = new Hulk();
        listOfHeroes[5] = new Thor();
    }

    @Override
    public void showHeroes() {
        System.out.println("Zvol si svojho hrdinu: ");
        System.out.println("1: CaptainAmerica");
        System.out.println("2: IronMan");
        System.out.println("3: BlackWidow");
        System.out.println("4: Hawkeye");
        System.out.println("5: Hulk");
        System.out.println("6: Thor");
    }

    @Override
    public void pickHeroes(Player player,int input) throws Exception{
        if(input == pickedHeroNum){
            throw new AlreadyPickedHeroException("Zvol si ineho hrdinu ako ma tvoj super");
        }

        switch (input){
            case 1 -> {
                player.setHero(listOfHeroes[0]);
                pickedHeroNum = input;
            }
            case 2 -> {
                player.setHero(listOfHeroes[1]);
                pickedHeroNum = input;
            }
            case 3 -> {
                player.setHero(listOfHeroes[2]);
                pickedHeroNum = input;
            }
            case 4 -> {
                player.setHero(listOfHeroes[3]);
                pickedHeroNum = input;
            }
            case 5 -> {
                player.setHero(listOfHeroes[4]);
                pickedHeroNum = input;
            }
            case 6 -> {
                player.setHero(listOfHeroes[5]);
                pickedHeroNum = input;
            }
            default -> throw new PickRightHeroException("Je potrebne si vybrat z uvedeneho zoznamu hrdinov");
        }
    }

    @Override
    public void presentPlayers(Player player1, Player player2) {
        System.out.println("Hrac "+player1.getNickname()+" si zvolil "+player1.getHero().getHero());
        System.out.println("Hrac "+player2.getNickname()+" si zvolil "+player2.getHero().getHero());
        System.out.println();

    }

    @Override
    public boolean aliveHeroes(Player player1, Player player2) {

        if((player1.getHero().getHealth() < 0 ) && (player2.getHero().getHealth() < 0)) {
            System.out.println("Suboj skoncil remizou");
            return false;
        }

        if(player1.getHero().getHealth() < 0) {
            System.out.println("Vyhral hrac: " + player2.getNickname());
            return false;
        }

        if(player2.getHero().getHealth() < 0) {
            System.out.println("Vyhral hrac: " + player1.getNickname());
            return false;
        }

        return true;
    }

    @Override
    public void addRoles(Player player1, Player player2) {
        double random = Math.random()*2;

        if(random > 1){
            attacker = player1;
            defender = player2;
        }
        else {
            attacker = player2;
            defender = player1;
        }

    }

    @Override
    public void switchRoles() {
        Player player;

        player = attacker;
        attacker = defender;
        defender = player;
    }

    @Override
    public void showRoles() {
        System.out.println("Toto kolo utoci "+attacker.getNickname()+"(energy:"+attacker.getHero().getEnergy()+")");
        System.out.println("Vzdialenost hracov je "+distance);
    }

    @Override
    public void showAttacks() {
        attacker.getHero().seeAttacks();
    }

    @Override
    public void chooseAttack(int input) throws Exception{
        switch (input){
            case 6 -> {
                if (distance == 1){
                    throw new TooCloseException("Uz si prilis blizko k nepriatelovi");
                }
                distance = attacker.getHero().moveTowards(distance);
            }
            case 7 -> {
                if (distance == 5){
                    throw new TooCloseException("Uz si prilis daleko od nepriatela");
                }
                distance = attacker.getHero().moveBackwards(distance);
            }
            case 1 -> {
                if (distance != 1){
                    throw new TooFarException("Stojis prilis daleko od nepriatela");
                }
                attacker.getHero().basicAttack(defender.getHero());
            }
            case 2 -> {
                if (distance == 1){
                    throw new TooCloseException("Stojis prilis blizko nepriatela");
                }
                if(attacker.getHero().getHero() == Heroes.HULK){
                    attacker.getHero().rangeAttack(defender.getHero(),distance);
                    distance = 1;
                }
                else {
                    attacker.getHero().rangeAttack(defender.getHero());
                }
            }
            case 3 -> {
                switch (attacker.getHero().getHero()) {
                    case BLACKWIDOW,CAPTAINAMERICA -> {
                        if (distance != 1) {
                            throw new TooFarException("Stojis prilis daleko od nepriatela");
                        }
                    }
                    case IRONMAN,THOR -> {
                        if (distance == 1){
                            throw new TooCloseException("Stojis prilis blizko nepriatela");
                        }
                    }
                }
                if(attacker.getHero().getHero() == Heroes.CAPTAINAMERICA) {
                    distance = 2;
                }
                attacker.getHero().thirdAttack(defender.getHero());
            }
            case 4 -> {
                switch (attacker.getHero().getHero()) {
                    case BLACKWIDOW,CAPTAINAMERICA,IRONMAN,THOR -> {
                        if (distance == 1){
                            throw new TooCloseException("Stojis prilis blizko nepriatela");
                        }
                    }
                    case HULK -> {
                        if (distance != 1) {
                            throw new TooFarException("Stojis prilis daleko od nepriatela");
                        }
                    }
                    case HAWKEYE -> {
                        if (attacker.getHero().getGadgets()[0].isActive()){
                            if (distance == 1){
                                throw new TooCloseException("Stojis prilis blizko nepriatela");
                            }
                        }
                        if (attacker.getHero().getGadgets()[1].isActive()){
                            if (distance != 1) {
                                throw new TooFarException("Stojis prilis daleko od nepriatela");
                            }
                        }
                    }
                }
                if(attacker.getHero().getHero() == Heroes.THOR) {
                    distance = 1;
                }
                attacker.getHero().fourthAttack(defender.getHero());
            }
            case 5 -> {
                switch (attacker.getHero().getHero()) {
                    case BLACKWIDOW -> {
                        if (distance == 1) {
                            throw new TooCloseException("Stojis prilis blizko nepriatela");
                        }
                    }
                    case HULK -> {
                        if (distance != 1) {
                            throw new TooFarException("Stojis prilis daleko od nepriatela");
                        }
                    }
                    case HAWKEYE -> {
                        if (attacker.getHero().getGadgets()[0].isActive()){
                            if (distance == 1){
                                throw new TooCloseException("Stojis prilis blizko nepriatela");
                            }
                        }
                        if (attacker.getHero().getGadgets()[1].isActive()){
                            if (distance != 1) {
                                throw new TooFarException("Stojis prilis daleko od nepriatela");
                            }
                        }
                    }
                }
                attacker.getHero().fifthAttack(defender.getHero());
            }
            default -> throw new PickBadAttackException("Musis zvolit z dostupnych utokov");
        }
        System.out.println();
    }

    @Override
    public void showScore() {
        System.out.println("Stav utocnika:");
        attacker.getHero().seeStats();
        System.out.println("Stav obrancu:");
        defender.getHero().seeStats();
    }

    @Override
    public void gainEnergy() {
        attacker.getHero().gainEnergy(10);
        defender.getHero().gainEnergy(10);
    }

    @Override
    public void checkStunned() {
        if(attacker.getHero().isStun()){
            switchRoles();
        }

        if(defender.getHero().isStun()){
            defender.getHero().removeStun();
        }
    }
}
