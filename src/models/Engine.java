package models;

import exceptions.ArgumentException;
import helpers.Validator;

public abstract class Engine {
    private static  final int MIN_MODEL_LENGTH = 3;

    private String model;
    private int horsePower;
    private int displacement;

    public Engine(String model, int horsePower, int displacement) throws ArgumentException {
        this.setModel(model);
        this.horsePower = horsePower;
        this.displacement = displacement;
    }

    public void setModel(String model) throws ArgumentException {
        if (Validator.validateEngine(model)) {
            this.model = model;

        } else {
            throw new ArgumentException("Model's name must be at least "
                    + MIN_MODEL_LENGTH
                    + " symbols long.");
        }
    }
}
