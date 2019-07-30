import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import models.Boat;
import models.Jet;
import models.PowerBoat;
import models.Race;

public class Main {
    public static void main(String[] args) {

        try {
            Boat b = new PowerBoat("Pesho", 200,
                    new Jet("aRod", 100, 9),
                    new Jet("Aroda", 100, 9));

            Boat b2 = new PowerBoat("IvanPeti", 2,
                    new Jet("aRod", 90, 8),
                    new Jet("Aroda", 90, 8));

            Boat b3 = new PowerBoat("Gosho", 2,
                    new Jet("aRod", 10, 1),
                    new Jet("Aroda", 10, 1));

            Race race =
                    new Race(100, 10, 10, true);

            race.addParticipant(b2);
            race.addParticipant(b3);
            race.addParticipant(b);

            race.startRace();

            System.out.println();

        } catch (ArgumentException  | DuplicateModelException e) {
            e.printStackTrace();
        }
    }
}
