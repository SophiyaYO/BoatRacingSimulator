package models;

import exceptions.ArgumentException;
import helpers.BoatValidator;

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
        if (BoatValidator.validateParam(cargoWeight)) {
            this.cargoWeight = cargoWeight;
        } else {
            throw new ArgumentException(this.generateErrorMessage("Cargo Weight"));
        }
    }


}
