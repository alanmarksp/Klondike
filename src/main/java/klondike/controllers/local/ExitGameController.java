package klondike.controllers.local;

import klondike.controllers.visitors.ActionControllerVisitor;
import klondike.models.Game;
import klondike.models.State;

public class ExitGameController extends BaseController implements klondike.controllers.ExitGameController {

    public ExitGameController(Game game) {
        super(game);
    }

    @Override
    public void accept(ActionControllerVisitor actionControllerVisitor) {
        assert actionControllerVisitor != null;
        actionControllerVisitor.visit(this);
    }

    @Override
    public void exit() {
        this.setState(State.EXIT);
    }
}
