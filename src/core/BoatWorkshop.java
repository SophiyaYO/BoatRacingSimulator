package core;

import models.Boat;
import models.Engine;
import repositories.Repository;

public class BoatWorkshop implements BoatFactory {

    private Repository<Engine> engineRepository;

    public void setEngineRepository(Repository<Engine> engineRepository) {
        this.engineRepository = engineRepository;
    }

    @Override
    public Boat produce(String[] args) {
        return null;
    }
}
