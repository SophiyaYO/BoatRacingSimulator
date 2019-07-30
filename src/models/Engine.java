package models;

import exceptions.ArgumentException;
import helpers.Validator;

public abstract class Engine {
    private static  final int MIN_MODEL_LENGTH = 3;

    private String model;
    private int horsepower;
    private int displacement;

    public Engine(String model, int horsePower, int displacement) throws ArgumentException {
        this.setModel(model);
        this.setHorsepower(horsePower);
        this.setDisplacement(displacement);
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

    private void setHorsepower(int horsepower) throws ArgumentException {
        if (Validator.validateParam(horsepower)) {
            this.horsepower = horsepower;

        } else {
           throw new  ArgumentException(Validator.generateErrorMessage("Horsepower"));
        }
    }

    private void setDisplacement(int displacement) throws ArgumentException {
        if (Validator.validateParam(displacement)) {
            this.displacement = displacement;

        } else {
            throw new  ArgumentException(Validator.generateErrorMessage("Displacement"));
        }
    }
}
