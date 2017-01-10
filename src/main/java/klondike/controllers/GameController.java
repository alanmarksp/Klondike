package klondike.controllers;

public interface GameController extends ScenarioController {

    ActionController getActionController(int option);
}
