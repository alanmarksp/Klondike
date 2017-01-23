package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.local.BaseController;
import klondike.controllers.visitors.ActionControllerVisitor;
import klondike.models.Game;
import klondike.models.State;

public abstract class MoveController extends BaseController implements klondike.controllers.move.MoveController {

    MoveController(Game game) {
        super(game);
    }

    @Override
    public void accept(ActionControllerVisitor actionControllerVisitor) {
        assert actionControllerVisitor != null;
        actionControllerVisitor.visit(this);
    }

    @Override
    public void finishGame() {
        this.setState(State.FINAL);
    }

    @Override
    public Error validateOrigin() {
        if (isOriginEmpty()) {
            return Error.EMPTY_STACK;
        }
        return null;
    }

    protected abstract boolean isOriginEmpty();
}
