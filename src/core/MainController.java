package core;

import exceptions.ArgumentException;
import exceptions.DuplicateModelException;
import models.Engine;
import repositories.Repository;
import repositories.RepositoryImpl;

import java.util.Scanner;

public class MainController {
    private Scanner scanner;
    private EngineFactory engineFactory;
    private Repository<Engine> engineRepository;

    public MainController(EngineFactory engineFactory) {
        this.scanner = new Scanner(System.in);
        this.engineFactory = engineFactory;
        this.engineRepository = new RepositoryImpl<>();
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

                }
            } catch (ArgumentException | DuplicateModelException e) {
                e.printStackTrace();
            }
        }


            line = scanner.nextLine();
        }

    }

