package models.interfaces;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import models.Boat;

import java.util.Set;

public interface RaceModel {
    int getDistance();

    int getCurrentSpeed();

    int getWindSpeed();

    boolean allowsMotorBoats();

    Set<Boat> getParticipants();

    void startRace();

    void addParticipant(Boat participant) throws ArgumentException, DuplicateModelException;

    String getStatistics();

    String getResult();
}
