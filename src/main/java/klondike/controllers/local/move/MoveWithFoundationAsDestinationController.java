package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.models.Game;

public abstract class MoveWithFoundationAsDestinationController extends MoveController implements
        klondike.controllers.move.MoveWithFoundationAsDestinationController {

    MoveWithFoundationAsDestinationController(Game game) {
        super(game);
    }

    public Error validateDestination(Card card, CardSuit cardSuit) {
        assert card != null;
        assert cardSuit != null;
        if (isFoundationEmpty(cardSuit) && card.getValue().isMinValue() || !isFoundationEmpty(cardSuit) &&
                card.getValue().ordinal() + 1 != getCardValueFromFoundation(cardSuit).ordinal()) {
            return Error.INVALID_MOVE;
        }
        return null;
    }
}
