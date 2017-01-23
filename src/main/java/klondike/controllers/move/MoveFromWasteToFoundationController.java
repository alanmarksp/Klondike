package klondike.controllers.move;

import klondike.controllers.Error;
import klondike.models.Card;

public interface MoveFromWasteToFoundationController extends MoveWithFoundationAsDestinationController {

    Error validateOrigin();

    Card getOriginCard();

    Card getDestinationCard();

    void pushBack(Card card);
}
