package klondike.controllers.local.move;

import klondike.controllers.local.Controller;
import klondike.controllers.visitors.ActionControllerVisitor;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.Game;
import klondike.models.State;

import java.util.Stack;

public abstract class MoveController extends Controller implements klondike.controllers.move.MoveController {

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
    public void accept(MoveControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }

    @Override
    public void move() {
        destination.push(origin.pop());
    }

    @Override
    public boolean isGameOver() {
        return getGame().isGameOver();
    }

    @Override
    public void finishGame() {
        getGame().setState(State.FINAL);
    }

    @Override
    public int getNumTableauStacks() {
        return Game.getNumTableauStacks();
    }
}
