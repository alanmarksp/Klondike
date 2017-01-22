package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.models.Card;
import klondike.models.CardValue;
import klondike.models.Game;

public abstract class MoveWithTableauStackAsDestination extends MoveController {

    MoveWithTableauStackAsDestination(Game game) {
        super(game);
    }

    public Error validateDestination(Card card, int tableauStackIndex) {
        if (!isTableauStackEmpty(tableauStackIndex) && !isCardOnTabelauStackFacedUp(tableauStackIndex)) {
            return Error.DESTINATION_CARD_FACE_DOWN;
        }
        if (isTableauStackEmpty(tableauStackIndex) && card.getValue() != CardValue.KING || !destination.isEmpty() &&
                card.getSuit().isSameColor(getCardSuitFromTableauStack(tableauStackIndex)) || !destination.isEmpty() &&
                card.getValue().ordinal() + 1 != getCardValueFromTableauStack(tableauStackIndex).ordinal()) {
            return Error.INVALID_MOVE;
        }
        return null;
    }
}
