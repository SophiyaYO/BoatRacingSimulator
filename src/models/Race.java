package models;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import helpers.Validator;

import java.util.*;
import java.util.stream.Collectors;

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
        this.participants = new LinkedHashSet<>();
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

    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    public Set<Boat> getParticipants() {
        return this.participants;
    }

    public void startRace() {
        this.participants = this.participants
                .stream()
                .sorted(
                        (f, s) -> {
                            System.out.println("First -> " + f.calcSpeed(this));
                            System.out.println("Second -> " +s.calcSpeed(this));
                                Double.compare(f.calcSpeed(this),
                                s.calcSpeed(this));
    })
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }


}
