package klondike.controllers.move;

import klondike.controllers.Error;
import klondike.models.Card;

public interface MoveFromWasteToTableauStackController extends MoveController {

    Error validateOrigin();

    Error validateDestination(Card card);

    void setDestination(int tableauStackIndex);

    Card getOriginCard();

    Card getDestinationCard();

    void pushBack(Card card);
}
