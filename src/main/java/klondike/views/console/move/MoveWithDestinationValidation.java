package klondike.views.console.move;

import klondike.controllers.Error;
import klondike.controllers.move.MoveWithDestinationValidationController;
import klondike.models.Card;
import klondike.views.console.ErrorView;

public abstract class MoveWithDestinationValidation extends MoveWithOriginValidation {

    protected boolean validateDestination(Card card, MoveWithDestinationValidationController moveWithDestinationValidationController) {
        Error error = moveWithDestinationValidationController.validateDestination(card);
        if (error != null) {
            pushBack(moveWithDestinationValidationController);
            new ErrorView(error).interact(moveWithDestinationValidationController);
            return false;
        }
        return true;
    }

    protected abstract void pushBack(MoveWithDestinationValidationController moveWithDestinationValidationController);

}
