package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.local.BaseController;
import klondike.controllers.visitors.ActionControllerVisitor;
import klondike.models.Card;
import klondike.models.Game;
import klondike.models.State;

import java.util.Stack;

public abstract class MoveController extends BaseController implements klondike.controllers.move.MoveController {

    protected Stack<Card> origin;

    protected Stack<Card> destination;

    MoveController(Game game) {
        super(game);
    }

    @Override
    public void accept(ActionControllerVisitor actionControllerVisitor) {
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
