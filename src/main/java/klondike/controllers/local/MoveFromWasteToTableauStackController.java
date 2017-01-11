package klondike.controllers.local;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.CardValue;
import klondike.models.Game;

public class MoveFromWasteToTableauStackController extends MoveController implements
        klondike.controllers.MoveFromWasteToTableauStackController {

    public MoveFromWasteToTableauStackController(Game game) {
        super(game);
        origin = game.getWaste();
    }

    @Override
    public void accept(MoveControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }

    @Override
    public Error validateMove() {
        if (origin.isEmpty()) {
            return Error.EMPTY_STACK;
        }
        if (!destination.isEmpty() && !getDestinationCard().isFaceUp()) {
            return Error.ORIGIN_CARD_FACE_DOWN;
        }
        if (destination.isEmpty() && getOriginCard().getValue() != CardValue.KING ||
                !destination.isEmpty() && getOriginCard().getSuit().isSameColor(getDestinationCard().getSuit()) ||
                !destination.isEmpty() && getDestinationCard().getValue().ordinal() != getOriginCard().getValue().ordinal() + 1) {
            return Error.INVALID_MOVE;
        }
        return null;
    }

    @Override
    public void setDestination(int tableauStackIndex) {
        destination = getGame().getTableauStack(tableauStackIndex);
    }

    @Override
    public Card getOriginCard() {
        return origin.peek();
    }

    @Override
    public Card getDestinationCard() {
        return destination.peek();
    }
}
