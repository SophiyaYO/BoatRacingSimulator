package models;

import exceptions.ArgumentException;

public class Jet extends Engine {

    public Jet(String model, int horsePower, int displacement)
            throws ArgumentException {

        super(model, horsePower, displacement);
    }



}
