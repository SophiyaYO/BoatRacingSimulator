package models;

public abstract class Engine {
    private String model;
    private int horsePower;
    private int displacement;

    public Engine(String model, int horsePower, int displacement) {
        this.model = model;
        this.horsePower = horsePower;
        this.displacement = displacement;
    }
}
