package klondike.controllers.move;

import klondike.controllers.Error;
import klondike.models.Card;
import klondike.models.CardSuit;

public interface MoveFromWasteToFoundationController extends MoveController {

    Error validateOrigin();

    Error validateDestination(Card card);

    void setDestination(CardSuit cardSuit);

    Card getOriginCard();

    Card getDestinationCard();

    void pushBack(Card card);
}
