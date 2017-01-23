package klondike.controllers.local;

import klondike.controllers.visitors.ScenarioControllerVisitor;
import klondike.models.Game;
import klondike.models.GameMode;
import klondike.models.State;

public class StartController extends BaseController implements klondike.controllers.StartController {

    public StartController(Game game) {
        super(game);
    }

    @Override
    public void start(GameMode gameMode) {
        assert this.getState() == State.INITIAL;
        setTable(gameMode);
        this.setState(State.IN_GAME);
    }

    @Override
    public void accept(ScenarioControllerVisitor scenarioControllerVisitor) {
        assert scenarioControllerVisitor != null;
        scenarioControllerVisitor.visit(this);
    }
}
