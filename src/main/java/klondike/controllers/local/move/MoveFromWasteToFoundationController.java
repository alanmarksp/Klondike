package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.models.CardValue;
import klondike.models.Game;

public class MoveFromWasteToFoundationController extends MoveController implements
        klondike.controllers.move.MoveFromWasteToFoundationController {

    public MoveFromWasteToFoundationController(Game game) {
        super(game);
        origin = game.getWaste();
    }

    @Override
    public Error validateMove() {
        setDestination(getOriginCard().getSuit());
        if (origin.isEmpty()) {
            return Error.EMPTY_STACK;
        }
        if (destination.isEmpty() && getOriginCard().getValue() != CardValue.ACE ||
                !destination.isEmpty() && getOriginCard().getSuit() != getDestinationCard().getSuit() ||
                !destination.isEmpty() && getDestinationCard().getValue().ordinal() != getOriginCard().getValue().ordinal() + 1) {
            return Error.INVALID_MOVE;
        }
        return null;
    }

    @Override
    public void setDestination(CardSuit cardSuit) {
        destination = getGame().getFoundation(cardSuit);
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