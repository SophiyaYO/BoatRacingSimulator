package core.commands.boatCommands;

import core.BoatFactory;
import models.Boat;
import repositories.Repository;

public class CreatePowerBoat extends BoatCommand {
    public CreatePowerBoat(Repository<Boat> boatRepository, BoatFactory boatFactory) {
        super(boatRepository, boatFactory);
    }
}
