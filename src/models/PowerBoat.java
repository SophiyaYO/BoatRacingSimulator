package models;

import exceptions.ArgumentException;

public class PowerBoat extends Boat {
    private Engine primaryEngine;
    private Engine secondaryEngine;

    protected PowerBoat(String model, int weight,
                        Engine primaryEngine, Engine secondaryEngine ) throws ArgumentException {

        super(model, weight);
        this.primaryEngine = primaryEngine;
        this.secondaryEngine = secondaryEngine;
    }
}
