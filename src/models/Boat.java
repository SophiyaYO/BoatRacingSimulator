package models;

import helpers.BoatValidator;

public abstract class Boat {
        private String model;
        private int weight;

        protected Boat(String model, int weight) {
                this.setModel(model);
                this.weight = weight;
        }

        private void setModel(String model) {
                if (BoatValidator.validateModel(model)) {
                        this.model = model;
                } else {
                        throw new
                }
        }


}
