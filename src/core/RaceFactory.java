package core;

import exceptions.ArgumentException;
import models.Race;

public interface RaceFactory {
    Race produce(String[] args) throws ArgumentException;
}
