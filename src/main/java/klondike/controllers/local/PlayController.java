package klondike.controllers.local;

import klondike.controllers.ActionController;
import klondike.controllers.ScenarioControllerVisitor;
import klondike.models.Game;
import klondike.models.State;
import klondike.utils.ClosedInterval;

public class PlayController extends Controller implements klondike.controllers.PlayController {

    private static final int NUM_ACTIONS = 9;

    PlayController(Game game) {
        super(game);
    }

    @Override
    public void accept(ScenarioControllerVisitor scenarioControllerVisitor) {
        scenarioControllerVisitor.visit(this);
    }

    @Override
    public ActionController getActionController(int option) {
        assert new ClosedInterval(0, NUM_ACTIONS).includes(option);
        assert this.getState() == State.IN_GAME;
        System.out.println(option);
        return null;
    }
}
