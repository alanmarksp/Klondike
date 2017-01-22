package klondike.controllers.move;

import klondike.controllers.Error;
import klondike.models.Card;
import klondike.models.CardSuit;

public interface MoveFromFoundationToTableauStackController extends MoveController {

    void pushBack(Card card);

    Error validateOrigin();

    Error validateDestination(Card card);

    void setOrigin(CardSuit cardSuit);

    void setDestination(int tableauStackIndex);

    Card getOriginCard();

    Card getDestinationCard();

    CardSuit getCardSuit();
}
