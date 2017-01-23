package klondike.controllers.move;

import klondike.controllers.Error;
import klondike.models.Card;

public interface MoveWithDestinationValidationController extends MoveController {

    Error validateDestination(Card card);

    void pushBack(Card card);
}
