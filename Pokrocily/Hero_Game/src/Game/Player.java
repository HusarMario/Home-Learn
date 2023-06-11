package Game;

import Heroes.Hero;

public class Player {
    private final String nickname;
    private Hero hero;

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public String getNickname() {
        return nickname;
    }

    public Hero getHero() {
        return hero;
    }
}


