package klondike.controllers.local;

import klondike.controllers.visitors.ScenarioControllerVisitor;
import klondike.models.Game;
import klondike.models.State;

public class StartController extends Controller implements klondike.controllers.StartController {

    public StartController(Game game) {
        super(game);
    }

    @Override
    public void start() {
        assert this.getState() == State.INITIAL;
        this.setState(State.IN_GAME);
    }

    @Override
    public void accept(ScenarioControllerVisitor scenarioControllerVisitor) {
        scenarioControllerVisitor.visit(this);
    }
}
