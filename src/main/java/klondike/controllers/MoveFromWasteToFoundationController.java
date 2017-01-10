package klondike.controllers;

import klondike.models.Card;
import klondike.models.CardSuit;

public interface MoveFromWasteToFoundationController extends MoveController {

    void setDestination(CardSuit cardSuit);

    Card getOriginCard();

    Card getDestinationCard();
}
