package core;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;
import models.Boat;
import models.Engine;
import models.Race;
import repositories.Repository;
import repositories.RepositoryImpl;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class MainController {
    private Scanner scanner;
    private EngineFactory engineFactory;
    private BoatFactory boatFactory;
    private Repository<Engine> engineRepository;
    private Repository<Boat> boatRepository;
    private Race race;

    public MainController(EngineFactory engineFactory, BoatFactory boatFactory) {
        this.scanner = new Scanner(System.in);
        this.engineRepository = new RepositoryImpl<>();
        this.boatRepository = new RepositoryImpl<>();
        this.engineFactory = engineFactory;
        this.boatFactory = boatFactory;

        this.boatFactory.setEngineRepository(this.engineRepository);
        this.race = null;
    }

    public void run() {

        String line = scanner.nextLine();

        while (!line.equalsIgnoreCase("end")) {

            String[] args = line.split("\\\\");

            String command = args[0];

            try {
                switch (command) {

                    case "CreateBoatEngine":
                        Engine engine = this.engineFactory.produce(args);

                        if (engine != null) {
                            engineRepository.add(engine);
                            System.out.printf(
                                    "Engine model %s with %s HP and displacement %s cm3 created successfully.%n",
                                    args[1],
                                    args[2],
                                    args[3]);
                        }

                        break;

                    case "CreateRowBoat":
                    case "CreatePowerBoat":
                    case "CreateSailBoat":
                    case "CreateYacht":
                        Boat boat = boatFactory.produce(args);

                        if (boat != null) {
                            boatRepository.add(boat);
                            System.out.printf("%s with model %s registered successfully.%n",
                                    args[0]
                                            .replace("Create", "")
                                            .replace("Boat", " Boat"),
                                    args[1]
                                    );

                        }
                        break;
                    case "OpenRace":
                        if (this.race == null) {
                            Race race = new Race(Integer.parseInt(args[1]),
                                    Integer.parseInt(args[2]),
                                    Integer.parseInt(args[3]),
                                    Boolean.parseBoolean(args[4]));


                            System.out.printf(
                                    "A new race with distance %s meters, wind speed %s and ocean current speed %s has been set.%n",
                                    args[1],
                                    args[2],
                                    args[3]);
                        }
                        break;
                    case "SignUpBoat":
                        this.race.addParticipant(this.boatRepository.get(args[1]));
                        System.out.printf(
                                "Boat with model %s has signed up for the current Race.%n",
                                args[1]);

                        break;

                    case "StartRace":
                        this.race.startRace();

                        List<Boat> finished = this.race.getParticipants().stream()
                                .limit(3)
                                .collect(Collectors.toList());

                        System.out.printf("First place: %s Model: %s Time: %.2f sec",
                                finished.get(0).getClass().getSimpleName(),
                                finished.get(0).getModel(),
                                this.race.getDistance() / (finished.get(0).calcSpeed(this.race))
                        );

                        System.out.printf("Second place: %s Model: %s Time: %.2f sec",
                                finished.get(1).getClass().getSimpleName(),
                                finished.get(1).getModel(),
                                this.race.getDistance() / (finished.get(1).calcSpeed(this.race))
                        );

                        System.out.printf("Third place: %s Model: %s Time: %.2f sec",
                                finished.get(2).getClass().getSimpleName(),
                                finished.get(2).getModel(),
                                this.race.getDistance() / (finished.get(2).calcSpeed(this.race))
                        );

                        this.race = null;
                        break;
                }
            } catch (ArgumentException |
                    DuplicateModelException |
                    NonExistantModelException e) {

                if (e instanceof NonExistantModelException) {
                    System.out.println();
                }
                System.out.println(e.getMessage());
            }
        }


        line = scanner.nextLine();
    }

}

