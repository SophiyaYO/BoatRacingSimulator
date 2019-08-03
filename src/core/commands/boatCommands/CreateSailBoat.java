package core.commands.boatCommands;

import core.BoatFactory;
import models.Boat;
import repositories.Repository;

public class CreateSailBoat extends BoatCommand {
    public CreateSailBoat(Repository<Boat> boatRepository, BoatFactory boatFactory) {
        super(boatRepository, boatFactory);

    }
}
