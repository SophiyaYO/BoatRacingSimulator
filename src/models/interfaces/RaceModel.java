package models.interfaces;

import models.Boat;

import java.util.Set;

public interface RaceModel {
    int getDistance();

    int getCurrentSpeed();

    int getWindSpeed();

    boolean allowsMotorBoats();

    Set<Boat> getParticipants();

    void startRace();

    void addParticipant(Boat participant);

    String getStatistics();

    String getResult();
}
