package models;

import exceptions.ArgumentException;

public class Sterndrive extends Engine {

    public Sterndrive(String model, int horsePower, int displacement) throws ArgumentException {
        super(model, horsePower, displacement);
    }

    @Override
    public int getOutputMethod() {
        return this.getHorsepower() * 7 + this.getDisplacement();
    }
}
