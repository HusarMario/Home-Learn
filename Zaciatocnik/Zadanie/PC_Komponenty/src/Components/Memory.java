package Components;

public class Memory {
    private final String size;
    private final String speed;

    public Memory(String size, String speed) {
        this.size = size;
        this.speed = speed;
    }

    public String getSize() {
        return size;
    }

    public String getSpeed() {
        return speed;
    }
}
