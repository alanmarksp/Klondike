package klondike.controllers.local.move;

import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.Game;
import klondike.views.console.ErrorView;

public class MoveFromDeckToWasteController extends MoveController implements
        klondike.controllers.move.MoveFromDeckToWasteController {

    public MoveFromDeckToWasteController(Game game) {
        super(game);
    }

    @Override
    public void accept(MoveControllerVisitor moveControllerVisitor) {
        assert moveControllerVisitor != null;
        moveControllerVisitor.visit(this);
    }

    @Override
    public void accept(ErrorView errorView) {
        assert errorView != null;
        errorView.visit(this);
    }

    @Override
    public Card pop() {
        return popFromDeck();
    }

    @Override
    public void push(Card card) {
        assert card != null;
        pushToWaste(card);
    }

    @Override
    protected boolean isOriginEmpty() {
        return isDeckEmpty();
    }

    @Override
    public int getOriginSize() {
        return getDeckSize();
    }
}
