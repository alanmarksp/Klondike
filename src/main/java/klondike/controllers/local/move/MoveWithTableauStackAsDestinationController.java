package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.models.Card;
import klondike.models.CardValue;
import klondike.models.Game;
import klondike.utils.ClosedInterval;

public abstract class MoveWithTableauStackAsDestinationController extends MoveController {

    MoveWithTableauStackAsDestinationController(Game game) {
        super(game);
    }

    public Error validateDestination(Card card, int tableauStackIndex) {
        assert card != null;
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        if (!isTableauStackEmpty(tableauStackIndex) && !isCardOnTabelauStackFacedUp(tableauStackIndex)) {
            return Error.DESTINATION_CARD_FACE_DOWN;
        }
        if (isTableauStackEmpty(tableauStackIndex) && card.getValue() != CardValue.KING || !isTableauStackEmpty(tableauStackIndex) &&
                card.getSuit().isSameColor(getCardSuitFromTableauStack(tableauStackIndex)) || !isTableauStackEmpty(tableauStackIndex) &&
                card.getValue().ordinal() + 1 != getCardValueFromTableauStack(tableauStackIndex).ordinal()) {
            return Error.INVALID_MOVE;
        }
        return null;
    }
}
