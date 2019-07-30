package core;

import java.util.Scanner;

public class MainController {
    private Scanner scanner;

    public MainController() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {

        String line = scanner.nextLine();

        while (!line.equalsIgnoreCase("end")) {




            line = scanner.nextLine();
        }

    }
}
