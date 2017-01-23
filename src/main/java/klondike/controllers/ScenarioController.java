package klondike.controllers;

import klondike.controllers.visitors.ScenarioControllerVisitor;

public interface ScenarioController extends PresenterController {

    void accept(ScenarioControllerVisitor scenarioControllerVisitor);
}
