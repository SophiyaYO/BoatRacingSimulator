import core.BoatWorkshop;
import core.MainController;
import models.Boat;
import models.Engine;
import repositories.Repository;
import repositories.RepositoryImpl;

public class Main {
    public static void main(String[] args) {

        Repository<Boat> boatRepository = new RepositoryImpl<>();
        Repository<Engine> engineRepository = new RepositoryImpl<>();
        CommandFactory commandFactory =
                new CommandWorkshop(new EngineWorkshop(), new BoatWorkshop(engineRepository), engineRepository, boatRepository, new RaceController());
        MainController controller = new MainController(new InputManager(), new OutputManager(), new CommandHandler(commandFactory));
        controller.run();

    }
}
