package klondike.controllers.move;

import klondike.models.CardSuit;

public interface MoveWithFoundationAsDestinationController extends MoveWithDestinationValidationController {

    void setDestination(CardSuit cardSuit);
}
