package klondike.controllers.move;

import klondike.models.Card;
import klondike.models.CardSuit;

public interface MoveFromWasteToFoundationController extends MoveController {

    void setDestination(CardSuit cardSuit);

    Card getOriginCard();

    Card getDestinationCard();
}
