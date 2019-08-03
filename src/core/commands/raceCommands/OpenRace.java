package core.commands.raceCommands;

import core.RaceFactory;
import core.controllers.interfaces.RaceManager;
import core.factories.RaceWorkshop;

public class OpenRace extends RaceCommand {
    private RaceFactory raceFactory;

    public OpenRace(RaceManager raceController) {
        super(raceController);
        raceFactory = new RaceWorkshop();
    }

    @Override
    public String execute(String[] args) {
        return null;
    }
}
