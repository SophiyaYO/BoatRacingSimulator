package models;

import exceptions.ArgumentException;

public class SailBoat extends Boat {


    public SailBoat(String model, int weight) throws ArgumentException {
        super(model, weight);
    }
}
