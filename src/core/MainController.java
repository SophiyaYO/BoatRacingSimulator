package core;

import models.Engine;

import java.util.Scanner;

public class MainController {
    private Scanner scanner;
    private EngineFactory engineFactory;

    public MainController(EngineFactory engineFactory) {
        this.scanner = new Scanner(System.in);
        this.engineFactory = engineFactory;
    }

    public void run() {

        String line = scanner.nextLine();

        while (!line.equalsIgnoreCase("end")) {




            line = scanner.nextLine();
        }

    }
}
