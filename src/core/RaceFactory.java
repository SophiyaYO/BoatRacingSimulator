package core;

import models.Race;

public interface RaceFactory {
    Race produce(String[] args);
}
