package core.commands.raceCommands;

import core.controllers.interfaces.RaceManager;

public class StartRace extends  RaceCommand {
    public StartRace(RaceManager raceController) {
        super(raceController);
    }

    @Override
    public String execute(String[] args) {
        String message;

            this.getRaceController().startRace();
            message = this.getRaceController().getRaceResult();


        return message;
    }
}
