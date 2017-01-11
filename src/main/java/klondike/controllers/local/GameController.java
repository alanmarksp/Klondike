package klondike.controllers.local;

import klondike.controllers.ActionController;
import klondike.controllers.local.move.*;
import klondike.controllers.visitors.ScenarioControllerVisitor;
import klondike.models.Game;
import klondike.models.State;
import klondike.utils.ClosedInterval;

import java.util.ArrayList;
import java.util.List;

public class GameController extends Controller implements klondike.controllers.GameController {

    private static final int NUM_ACTIONS = 9;

    private List<ActionController> actionControllers;

    public GameController(Game game) {
        super(game);
        actionControllers = new ArrayList<>();

        actionControllers.add(new MoveFromDeckToWasteController(game));
        actionControllers.add(new MoveFromWasteToDeckController(game));
        actionControllers.add(new MoveFromWasteToFoundationController(game));
        actionControllers.add(new MoveFromWasteToTableauStackController(game));
        actionControllers.add(new MoveFromTableauStackToFoundationController(game));
        actionControllers.add(new MoveFromTableauStackToTableauStackController(game));
        actionControllers.add(new MoveFromFoundationToTableauStackController(game));
        actionControllers.add(new FlipTableauCardController(game));
        actionControllers.add(new ExitGameController(game));
    }

    @Override
    public void accept(ScenarioControllerVisitor scenarioControllerVisitor) {
        scenarioControllerVisitor.visit(this);
    }

    @Override
    public ActionController getActionController(int option) {
        assert new ClosedInterval(0, NUM_ACTIONS).includes(option);
        assert this.getState() == State.IN_GAME;
        return actionControllers.get(option);
    }
}
