package models;

import exceptions.ArgumentException;
import helpers.Validator;

public abstract class Engine implements Comparable<Engine> {
    private static final int MIN_MODEL_LENGTH = 3;

    private String model;
    private int horsepower;
    private int displacement;

    public Engine(String model, int horsePower, int displacement) throws ArgumentException {
        this.setModel(model);
        this.setHorsepower(horsePower);
        this.setDisplacement(displacement);
    }

    private void setModel(String model) throws ArgumentException {
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
            throw new ArgumentException(Validator.generateErrorMessage("Horsepower"));
        }
    }

    private void setDisplacement(int displacement) throws ArgumentException {
        if (Validator.validateParam(displacement)) {
            this.displacement = displacement;

        } else {
            throw new ArgumentException(Validator.generateErrorMessage("Displacement"));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null
                ||
                getClass().getSuperclass()
                !=
                o.getClass().getSuperclass()) return false;

        Engine engine = (Engine) o;

        return model.equals(engine.model);
    }

    @Override
    public int hashCode() {
        return model.hashCode();
    }

    @Override
    public int compareTo(Engine o) {
        return this.model.compareTo(o.model);
    }
}
