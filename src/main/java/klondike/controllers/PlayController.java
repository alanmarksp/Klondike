package klondike.controllers;

public interface PlayController extends ScenarioController {

    ActionController getActionController(int option);
}
