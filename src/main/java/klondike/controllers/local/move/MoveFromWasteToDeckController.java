package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.Game;
import klondike.views.console.ErrorView;

public class MoveFromWasteToDeckController extends MoveController implements
        klondike.controllers.move.MoveFromWasteToDeckController {

    public MoveFromWasteToDeckController(Game game) {
        super(game);
        origin = game.getWaste();
        destination = game.getDeck();
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
    public Card pop() {
        return popFromWaste();
    }

    @Override
    public void push(Card card) {
        pushToDeck(card);
    }

    @Override
    protected boolean isOriginEmpty() {
        return isWasteEmpty();
    }

    @Override
    public Error validateDestination() {
        if (!isDeckEmpty()) {
            return Error.NON_EMPTY_DECK;
        }
        return null;
    }

    @Override
    public int getOriginSize() {
        return getWasteSize();
    }
}
