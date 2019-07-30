package core;

import exceptions.ArgumentException;
import exceptions.NonExistantModelException;
import models.Boat;
import models.Engine;
import repositories.Repository;

public interface BoatFactory {
    Boat produce(String[] args) throws ArgumentException, NonExistantModelException;

    void setEngineRepository(Repository<Engine> engineRepository);
}
