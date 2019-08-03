package models;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import helpers.Validator;
import models.interfaces.RaceModel;

import javax.naming.InsufficientResourcesException;
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
        Map<String, Integer> boatsByCount = new TreeMap<>();

        for (Boat participant : participants) {
            String className = participant.getClass().getSimpleName();

            if (!boatsByCount.containsKey(className)) {
                boatsByCount.put(className, 1);

            } else {
                boatsByCount.put(className, boatsByCount.get(className) + 1);
            }
        }

        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, Integer> entry : boatsByCount.entrySet()) {
            double percentage = (entry.getValue() * 1d / this.participants.size()) * 100;

            builder
                    .append(entry.getKey())
                    .append(" -> ")
                    .append(String.format("%.2f%%", percentage))
                    .append(System.lineSeparator());
        }

        return builder.toString().trim();
    }

    @Override
    public String getResult() {
        StringBuilder builder = new StringBuilder();

        List<Boat> finished = this.participants
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        String[] placeTable = {
                "First place: ",
                "Second place: ",
                "Third place: "};

        for (int i = 0; i < finished.size(); i++) {
            builder
                    .append(placeTable[i])
                    .append(finished.get(i).getClass().getSimpleName())
                    .append(" Model: ")
                    .append(finished.get(i).getModel())
                    .append(" Time: ");

            double time = this.getDistance() / finished.get(i).calcSpeed(this);

            String timeValue =
                    (time < 0
                            || time == Double.POSITIVE_INFINITY
                            || time == Double.NEGATIVE_INFINITY)
                            ? "Did not finish!"
                            : String.format("%.2f sec", time);
        }

        return builder.toString().trim();
    }

    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    public Set<Boat> getParticipants() {
        return this.participants;
    }

    public void startRace() throws InsufficientResourcesException {
        if (this.participants.size() < 3) {
            throw new InsufficientResourcesException("Not enough contestants for the race.");
        }

        this.participants = this.participants
                .stream()
                .sorted((f, s) -> {

                    if (f.calcSpeed(this) < 0 && s.calcSpeed(this) < 0) {
                        return 0;
                    }

                    return Double.compare(s.calcSpeed(this), f.calcSpeed(this));

                })
                .collect(Collectors.toCollection(LinkedHashSet::new));

    }

    public int getWindSpeed() {
        return this.windSpeed;
    }

    @Override
    public boolean allowsMotorBoats() {
        return this.allowMotorBoats;
    }


}
