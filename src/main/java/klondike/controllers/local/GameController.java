package klondike.controllers.local;

import klondike.controllers.Action;
import klondike.controllers.ActionController;
import klondike.controllers.local.move.*;
import klondike.controllers.visitors.ScenarioControllerVisitor;
import klondike.models.Game;
import klondike.models.State;
import klondike.utils.ClosedInterval;

import java.util.HashMap;
import java.util.Map;

public class GameController extends BaseController implements klondike.controllers.GameController {

    private Map<Action, ActionController> actionControllers;

    public GameController(Game game) {
        super(game);
        actionControllers = new HashMap<>();
        actionControllers.put(Action.MOVE_FROM_DECK_TO_WASTE, new MoveFromDeckToWasteController(game));
        actionControllers.put(Action.MOVE_FROM_WASTE_TO_DECK, new MoveFromWasteToDeckController(game));
        actionControllers.put(Action.MOVE_FROM_WASTE_TO_FOUNDATION, new MoveFromWasteToFoundationController(game));
        actionControllers.put(Action.MOVE_FROM_WASTE_TO_TABLEAU_STACK, new MoveFromWasteToTableauStackController(game));
        actionControllers.put(Action.MOVE_FROM_TABLEAU_STACK_TO_FOUNDATION, new MoveFromTableauStackToFoundationController(game));
        actionControllers.put(Action.MOVE_FROM_TABLEAU_STACK_TO_TABLEAU_STACK, new MoveFromTableauStackToTableauStackController(game));
        actionControllers.put(Action.MOVE_FROM_FOUNDATION_TO_TABLEAU_STACK, new MoveFromFoundationToTableauStackController(game));
        actionControllers.put(Action.FLIP_CARD_ON_TABLEAU_STACK, new FlipTableauCardController(game));
        actionControllers.put(Action.EXIT_GAME, new ExitGameController(game));
    }

    @Override
    public void accept(ScenarioControllerVisitor scenarioControllerVisitor) {
        scenarioControllerVisitor.visit(this);
    }

    @Override
    public ActionController getActionController(Action action) {
        assert new ClosedInterval(0, Action.values().length).includes(action.ordinal());
        assert this.getState() == State.IN_GAME;
        return actionControllers.get(action);
    }
}
