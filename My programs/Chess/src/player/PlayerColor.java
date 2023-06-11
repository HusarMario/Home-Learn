package player;

public enum PlayerColor {
    WHITE("white"),
    RED("red");

    private final String color;

    PlayerColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
