package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.Game;
import klondike.views.console.ErrorView;

public class MoveFromDeckToWasteController extends MoveController implements
        klondike.controllers.move.MoveFromDeckToWasteController {

    public MoveFromDeckToWasteController(Game game) {
        super(game);
        origin = game.getDeck();
        destination = game.getWaste();
    }

    @Override
    public void accept(MoveControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }

    @Override
    public void accept(ErrorView errorView) {
        errorView.visit(this);
    }

    @Override
    public void move() {
        for (int i = 0; i < Game.getGameMode() && !origin.isEmpty(); i++) {
            destination.push(origin.pop().flipUp());
        }
    }

    @Override
    public Error validateMove() {
        if (origin.isEmpty()) {
            return Error.EMPTY_STACK;
        }
        return null;
    }

    @Override
    public Card pop() {
        return popFromDeck();
    }

    @Override
    public void push(Card card) {
        pushToWaste(card);
    }

    @Override
    public Error validateOrigin() {
        if (isDeckEmpty()) {
            return Error.EMPTY_STACK;
        }
        return null;
    }

    @Override
    public int getOriginSize() {
        return getDeckSize();
    }
}
