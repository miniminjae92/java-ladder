import controller.LadderController;
import service.LadderService;

public class Application {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new LadderService());
        ladderController.run();
    }
}
