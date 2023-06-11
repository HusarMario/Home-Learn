package Gadgets;

public abstract class Gadget {
    protected double health;
    protected double energy;
    protected double armor;
    protected double attack;
    protected boolean active = false;

    public double getHealth() {
        return health;
    }

    public double getEnergy() {
        return energy;
    }

    public double getArmor() {
        return armor;
    }

    public double getAttack() {
        return attack;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}



