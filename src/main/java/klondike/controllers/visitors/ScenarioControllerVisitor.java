package klondike.controllers.visitors;

import klondike.controllers.ContinueController;
import klondike.controllers.GameController;
import klondike.controllers.local.StartController;

public interface ScenarioControllerVisitor {

    void visit(StartController startController);

    void visit(GameController gameController);

    void visit(ContinueController continueController);
}
