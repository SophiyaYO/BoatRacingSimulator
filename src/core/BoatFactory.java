package core;

import models.Boat;

public interface BoatFactory {
    Boat produce(String[] args);
}
