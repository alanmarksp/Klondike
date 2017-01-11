package klondike.controllers.move;

import klondike.models.Card;

public interface MoveFromWasteToTableauStackController extends MoveController {

    void setDestination(int tableauStackIndex);

    Card getOriginCard();

    Card getDestinationCard();
}
