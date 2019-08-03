package models;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import helpers.Validator;
import models.interfaces.RaceModel;

import java.util.*;
import java.util.stream.Collectors;

public class Race implements RaceModel {
    private int distance;
    private int windSpeed;
    private int currentSpeed;
    private boolean allowMotorBoats;
    private Set<Boat> participants;


    public Race(int distance, int windSpeed,
                int currentSpeed, boolean allowMotorBoats)
            throws ArgumentException {

        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.currentSpeed = currentSpeed;
        this.allowMotorBoats = allowMotorBoats;
        this.participants = new LinkedHashSet<>();
    }

    private void setDistance(int distance) throws ArgumentException {
        if (Validator.validateParam(distance)) {
            this.distance = distance;

        } else {
            throw new ArgumentException(Validator.generateErrorMessage("Distance"));
        }
    }

    public int getDistance() {
        return this.distance;
    }

    public void addParticipant(Boat participant) throws DuplicateModelException, ArgumentException {
       boolean hasEngine = Arrays.stream(participant.getClass().getDeclaredFields())
               .filter(field -> field.getType().equals(Engine.class))
               .findFirst()
               .orElse(null)
               != null;

        if (!this.allowMotorBoats && hasEngine) {
            throw new ArgumentException("The specified boat does not meet the race constraints.");

        }

        if (!this.participants.add(participant)) {
            throw new DuplicateModelException();
        }

    }

    @Override
    public String getStatistics() {
        return null;
    }

    @Override
    public String getResult() {
        return null;
    }

    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    public int getWindSpeed() {
        return this.windSpeed;
    }

    @Override
    public boolean allowsMotorBoats() {
        return this.allowMotorBoats;
    }

    public Set<Boat> getParticipants() {
        return this.participants;
    }

    public void startRace() {
        this.participants = this.participants
                .stream()
                .sorted(
                        (f, s) -> {
                            System.out.println(f.getModel() + " -> " + f.calcSpeed(this));
                            System.out.println(s.getModel() + " -> " + s.calcSpeed(this));
                            return Double.compare(s.calcSpeed(this),
                                   f.calcSpeed(this));
                        })
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }


}
