package klondike.controllers.local.move;

import klondike.models.Card;
import klondike.models.Game;

public abstract class MoveWithCardValidationController extends MoveController {

    MoveWithCardValidationController(Game game) {
        super(game);
    }

    public Card getOriginCard() {
        return origin.peek();
    }

    public Card getDestinationCard() {
        if (!destination.isEmpty()) {
            return destination.peek();
        }
        return null;
    }
}
