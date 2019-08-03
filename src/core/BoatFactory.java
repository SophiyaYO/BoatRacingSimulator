package core;

import exceptions.ArgumentException;
import exceptions.NonExistanceModelException;
import models.Boat;
import models.Engine;
import repositories.Repository;

public interface BoatFactory {
    Boat produce(String[] args) throws ArgumentException, NonExistanceModelException;

    void setEngineRepository(Repository<Engine> engineRepository);
}
