package core;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;
import models.Boat;
import models.Engine;
import repositories.Repository;
import repositories.RepositoryImpl;

import java.util.Scanner;

public class MainController {
    private Scanner scanner;
    private EngineFactory engineFactory;
    private BoatFactory boatFactory;
    private Repository<Engine> engineRepository;
    private Repository<Boat> boatRepository;

    public MainController(EngineFactory engineFactory, BoatFactory boatFactory) {
        this.scanner = new Scanner(System.in);
        this.engineRepository = new RepositoryImpl<>();
        this.boatRepository = new RepositoryImpl<>();
        this.engineFactory = engineFactory;
        this.boatFactory = boatFactory;

        this.boatFactory.setEngineRepository(this.engineRepository);
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
                        boatRepository.add(boatFactory.produce(args));
                        break;

                }
            } catch (ArgumentException |
                    DuplicateModelException |
                    NonExistantModelException e) {

                System.out.println(e.getMessage());
            }
        }


        line = scanner.nextLine();
    }

}

