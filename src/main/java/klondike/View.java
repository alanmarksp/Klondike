package klondike;

import klondike.controllers.ScenarioController;
import klondike.controllers.ScenarioControllerVisitor;

public interface View extends ScenarioControllerVisitor {

    void interact(ScenarioController controller);
}
