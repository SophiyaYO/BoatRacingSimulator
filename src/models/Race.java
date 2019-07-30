package models;

import exceptions.ArgumentException;
import helpers.Validator;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private int distance;
    private int windSpeed;
    private int currentSpeed;
    private boolean allowMottorBoats;
    private List<Boat> participants;


    public Race(int distance, int windSpeed,
                int currentSpeed, boolean allowMotorBoats)
            throws ArgumentException {

        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.currentSpeed = currentSpeed;
        this.allowMottorBoats = allowMotorBoats;
        this.participants = new ArrayList<>();
    }

    private void setDistance(int distance) throws ArgumentException {
        if (Validator.validateParam(distance)) {
            this.distance = distance;

        } else {
            throw new ArgumentException(Validator.generateErrorMessage("Distance"));
        }
    }

    public void addParticipant(Boat participant) {
        this.participants.add(participant);
    }

    public List<Boat> getParticipants() {
        return this.participants;
    }
}
