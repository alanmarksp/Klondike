package klondike.controllers;

import klondike.models.Card;

public interface MoveFromTableauStackToTableauStackController extends MoveController {

    void setOrigin(int tableauStackIndex);

    void setDestination(int tableauStackIndex);

    void setNumCardsToMove(int numCardsToMove);

    Card getOriginCard();

    Card getDestinationCard();
}
