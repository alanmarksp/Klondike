package klondike.controllers;

import klondike.controllers.visitors.ScenarioControllerVisitor;

public interface ScenarioController extends Controller {

    void accept(ScenarioControllerVisitor scenarioControllerVisitor);
}
