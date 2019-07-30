package core;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
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
        this.engineFactory = engineFactory;
        this.boatFactory = boatFactory;
        this.engineRepository = new RepositoryImpl<>();
        this.boatRepository = new RepositoryImpl<>();

    }

    public void run() {

        String line = scanner.nextLine();

        while (!line.equalsIgnoreCase("end")) {

            String[] args = line.split("\\\\");

            String command = args[0];

            try {
                switch (command) {

                    case "CreateBoatEngine":
                        engineRepository.add(this.engineFactory.produce(args));
                        break;
                    case "CreateRowBoat":
                    case "CreatePowerBoat":
                    case "CreateSailBoat":
                    case "CreateYacht":
boatRepository.add();
                        break;

                }
            } catch (ArgumentException | DuplicateModelException e) {
                e.printStackTrace();
            }
        }


            line = scanner.nextLine();
        }

    }

