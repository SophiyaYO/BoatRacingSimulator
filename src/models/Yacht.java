package models;

import exceptions.ArgumentException;
import helpers.Validator;

public class Yacht extends Boat {
    private  Engine engine;
    private int cargoWeight;

    public Yacht(String model, int weight,
                 Engine engine, int cargoWeight) throws ArgumentException {

        super(model, weight);
        this.engine = engine;
        this.setCargoWeight(cargoWeight);
    }

    private void setCargoWeight(int cargoWeight) throws ArgumentException {
        if (Validator.validateParam(cargoWeight)) {
            this.cargoWeight = cargoWeight;
        } else {
            throw new ArgumentException(Validator.generateErrorMessage("Cargo Weight"));
        }
    }


}
