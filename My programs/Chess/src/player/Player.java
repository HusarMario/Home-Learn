package player;

public class Player {
    private String nick;
    private PlayerColor color;

    public Player(String nick, PlayerColor color) {
        this.nick = nick;
        this.color = color;
    }

    public String getNick() {
        return nick;
    }

    public PlayerColor getColor() {
        return color;
    }
}
