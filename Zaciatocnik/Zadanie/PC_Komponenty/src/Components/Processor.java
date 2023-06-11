package Components;

public class Processor {
    private final String producer;
    private final String frequency;

    public Processor(String producer, String frequency) {
        this.producer = producer;
        this.frequency = frequency;
    }

    public String getProducer() {
        return producer;
    }

    public String getFrequency() {
        return frequency;
    }
}
