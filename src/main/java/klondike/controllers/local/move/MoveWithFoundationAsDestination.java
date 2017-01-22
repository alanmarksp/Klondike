package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.models.CardValue;
import klondike.models.Game;

public abstract class MoveWithFoundationAsDestination extends MoveController {

    MoveWithFoundationAsDestination(Game game) {
        super(game);
    }

    public Error validateDestination(Card card, CardSuit cardSuit) {
        if (isFoundationEmpty(cardSuit) && card.getValue() != CardValue.ACE || !isFoundationEmpty(cardSuit) &&
                card.getValue().ordinal() + 1 != getCardValueFromFoundation(cardSuit).ordinal()) {
            return Error.INVALID_MOVE;
        }
        return null;
    }
}
