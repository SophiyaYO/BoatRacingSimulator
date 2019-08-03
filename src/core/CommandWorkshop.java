package core;

import core.commands.interfaces.Command;
import models.Boat;
import models.Engine;
import repositories.Repository;

public class CommandWorkshop implements CommandFactory {
   private EngineFactory engineFactory;
   private BoatFactory boatFactory;
   private Repository<Engine> engineRepository;
   private Repository<Boat> boatRepository;
   private RaceManager raceManager;


    @Override
    public Command produce(String type) {
        return null;
    }
}
