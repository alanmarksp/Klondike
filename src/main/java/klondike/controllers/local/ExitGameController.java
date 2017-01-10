package klondike.controllers.local;

import klondike.controllers.visitors.ActionControllerVisitor;
import klondike.models.Game;
import klondike.models.State;

public class ExitGameController extends Controller implements klondike.controllers.ExitGameController {

    ExitGameController(Game game) {
        super(game);
    }

    @Override
    public void accept(ActionControllerVisitor actionControllerVisitor) {
        actionControllerVisitor.visit(this);
    }

    @Override
    public void exit() {
        this.setState(State.EXIT);
    }
}
