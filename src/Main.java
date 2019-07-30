import exceptions.ArgumentException;
import models.Boat;
import models.RowBoat;
import models.SailBoat;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        try {
            Boat b = new SailBoat("Pesho", 200, 10);
            Boat b2 = new RowBoat("Canko", 342, 10);

            Set<Boat> boats = new HashSet<>();

            boats.add(b);
            boats.add(b2);


        } catch (ArgumentException e) {
            e.printStackTrace();
        }
    }
}
