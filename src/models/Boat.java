package models;

import exceptions.ArgumentException;
import helpers.BoatValidator;

public abstract class Boat {
        private static  final int MIN_MODEL_LENGTH = 5;
        private String model;
        private int weight;

        protected Boat(String model, int weight) throws ArgumentException {
                this.setModel(model);
                this.setWeight(weight);
        }

        private void setWeight(int weight) throws ArgumentException {
                if (BoatValidator.validateParam(weight)) {
                        this.weight = weight;
                } else {
                        throw new ArgumentException("Boat’s  must be a positive integer.");
                }
        }

        private void setModel(String model) throws ArgumentException {
                if (BoatValidator.validateModel(model)) {
                        this.model = model;
                } else {
                        throw new ArgumentException(
                                "Model's name must be at least "
                                        + MIN_MODEL_LENGTH
                                        + " symbols long.");
                }
        }


}
