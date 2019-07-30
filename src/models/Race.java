package models;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import helpers.Validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Race {
    private int distance;
    private int windSpeed;
    private int currentSpeed;
    private boolean allowMottorBoats;
    private Set<Boat> participants;


    public Race(int distance, int windSpeed,
                int currentSpeed, boolean allowMotorBoats)
            throws ArgumentException {

        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.currentSpeed = currentSpeed;
        this.allowMottorBoats = allowMotorBoats;
        this.participants = new HashSet<>();
    }

    private void setDistance(int distance) throws ArgumentException {
        if (Validator.validateParam(distance)) {
            this.distance = distance;

        } else {
            throw new ArgumentException(Validator.generateErrorMessage("Distance"));
        }
    }

    public void addParticipant(Boat participant) throws DuplicateModelException {
        if (!this.participants.add(participant)) {
            throw new DuplicateModelException();
        }
        this.participants.add(participant);
    }

    public Set<Boat> getParticipants() {
        return this.participants;
    }
}
