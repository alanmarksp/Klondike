package klondike.controllers.move;

import klondike.controllers.Error;
import klondike.models.Card;

public interface MoveFromTableauStackToTableauStackController extends MoveWithDestinationValidationController {

    Error validateOrigin();

    void setOrigin(int tableauStackIndex);

    void setDestination(int tableauStackIndex);

    int getNumCardsToMove();

    void setNumCardsToMove(int numCardsToMove);

    Card getOriginCard();

    Card getDestinationCard();

    int getTableauStackIndex();

    void pushBack(Card card);
}
