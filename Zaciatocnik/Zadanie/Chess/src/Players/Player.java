package Players;

import Piecees.Colour;

public class Player {
    private String name;
    private final Colour colour;

    public Player(Colour colour) {
        this.colour = colour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Colour getColour() {
        return colour;
    }
}


