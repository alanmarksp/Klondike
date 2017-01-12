package klondike.controllers;

import klondike.controllers.visitors.ScenarioControllerVisitor;

public interface ScenarioController extends BaseController {

    void accept(ScenarioControllerVisitor scenarioControllerVisitor);
}
