package core;

import exceptions.ArgumentException;
import exceptions.NonExistanceModelException;
import models.Boat;

public interface BoatFactory {
    Boat produce(String[] args) throws ArgumentException, NonExistanceModelException;

}
