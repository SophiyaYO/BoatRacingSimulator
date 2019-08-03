package core.commands.boatCommands;

import core.BoatFactory;
import models.Boat;
import repositories.Repository;

public class CreateRowBoat extends BoatCommand {
    public CreateRowBoat(Repository<Boat> boatRepository, BoatFactory boatFactory) {
        super(boatRepository, boatFactory);
    }
}
