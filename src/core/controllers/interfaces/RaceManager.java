package core.controllers.interfaces;

import models.Boat;
import models.Race;

public interface RaceManager {
    void setRace(Race race) ;

    void addBoat(Boat boat);

    void startRace();

    String getRaceResult();

    String getStatistics();
}
