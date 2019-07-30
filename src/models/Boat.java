package models;

import exceptions.ArgumentException;
import helpers.BoatValidator;

public abstract class Boat {
        private static  final int MIN_MODEL_LENGHT = 5;
        private String model;
        private int weight;

        protected Boat(String model, int weight) throws ArgumentException {
                this.setModel(model);
                this.setWeight(weight);
        }

        protected void setWeight(int weight) {

        }

        private void setModel(String model) throws ArgumentException {
                if (BoatValidator.validateModel(model)) {
                        this.model = model;
                } else {
                        throw new ArgumentException(
                                "Model's name must be at least "
                                        + MIN_MODEL_LENGHT
                                        + " symbols long.");
                }
        }


}
