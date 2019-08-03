package models.interfaces;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import models.Boat;

import javax.naming.InsufficientResourcesException;
import java.util.Set;

public interface RaceModel {
    int getDistance();

    int getCurrentSpeed();

    int getWindSpeed();

    boolean allowsMotorBoats();

    Set<Boat> getParticipants();

    void startRace() throws InsufficientResourcesException;

    void addParticipant(Boat participant) throws ArgumentException, DuplicateModelException;

    String getStatistics();

    String getResult();
}
