package core.commands.raceCommands;

import core.controllers.interfaces.RaceManager;
import exceptions.NonExistanceModelException;
import models.Boat;
import repositories.Repository;

public class SignUpBoat extends RaceCommand {
    private Repository<Boat> boatRepository;


    public SignUpBoat(RaceManager raceController, Repository<Boat> boatRepository) {
        super(raceController);
        this.boatRepository = boatRepository;
    }

    @Override
    public String execute(String[] args) {
        String message;

        String model = args[1];

        try {
            this.getRaceController().addBoat(this.boatRepository.get(model));
            message = String.format("Boat with model %s has signed up for the current Race.", model);
        } catch (NonExistanceModelException e) {
            message = e.getMessage();
        }

        return message;
    }
}
