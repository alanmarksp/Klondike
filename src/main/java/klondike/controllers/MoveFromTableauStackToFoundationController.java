package klondike.controllers;

import klondike.models.Card;
import klondike.models.CardSuit;

public interface MoveFromTableauStackToFoundationController extends MoveController {

    void setOrigin(int tableauStackIndex);

    void setDestination(CardSuit cardSuit);

    Card getOriginCard();

    Card getDestinationCard();
}
