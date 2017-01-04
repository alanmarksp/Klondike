package klondike.controllers.local;

import klondike.controllers.ScenarioControllerVisitor;
import klondike.models.Game;
import klondike.models.State;

public class ContinueController extends Controller implements klondike.controllers.ContinueController {

    ContinueController(Game game) {
        super(game);
    }

    @Override
    public void accept(ScenarioControllerVisitor scenarioControllerVisitor) {
        scenarioControllerVisitor.visit(this);
    }

    @Override
    public void resume(boolean restart) {
        assert this.getState() == State.FINAL;
        if (restart) {
            this.reset();
            this.setState(State.IN_GAME);
        } else {
            this.setState(State.EXIT);
        }
    }
}
