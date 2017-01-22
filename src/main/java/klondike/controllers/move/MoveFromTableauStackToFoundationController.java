package klondike.controllers.move;

import klondike.controllers.Error;
import klondike.models.Card;
import klondike.models.CardSuit;

public interface MoveFromTableauStackToFoundationController extends MoveController {

    Error validateOrigin();

    Error validateDestination(Card card);

    void setOrigin(int tableauStackIndex);

    void setDestination(CardSuit cardSuit);

    Card getOriginCard();

    Card getDestinationCard();

    int getTableauStackIndex();

    void pushBack(Card card);
}
