package klondike.controllers.move;

import klondike.models.Card;
import klondike.models.CardSuit;

public interface MoveFromFoundationToTableauStackController extends MoveController {

    void setOrigin(CardSuit cardSuit);

    void setDestination(int tableauStackIndex);

    Card getOriginCard();

    Card getDestinationCard();
}
