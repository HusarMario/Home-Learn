package Game;

public interface CommandsInterface {
    void createGame();
    void showHeroes();
    void pickHeroes(Player player,int input) throws Exception;
    void presentPlayers(Player player1,Player player2);
    boolean aliveHeroes(Player player1,Player player2);
    void addRoles(Player player1,Player player2);
    void switchRoles();
    void showRoles();
    void showAttacks();
    void chooseAttack(int input) throws Exception;
    void showScore();
    void gainEnergy();
    void checkStunned();
}
