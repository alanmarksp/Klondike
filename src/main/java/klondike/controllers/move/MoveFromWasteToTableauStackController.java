package klondike.controllers.move;

import klondike.controllers.Error;
import klondike.models.Card;

public interface MoveFromWasteToTableauStackController extends MoveWithTableauStackAsDestinationController {

    Error validateOrigin();

    Card getOriginCard();

    Card getDestinationCard();

    void pushBack(Card card);
}
