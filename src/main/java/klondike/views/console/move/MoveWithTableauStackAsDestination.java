package klondike.views.console.move;

import klondike.controllers.move.MoveWithDestinationValidationController;
import klondike.controllers.move.MoveWithTableauStackAsDestinationController;
import klondike.models.Card;
import klondike.views.console.MenuView;
import klondike.views.console.models.GameView;

public abstract class MoveWithTableauStackAsDestination extends MoveWithDestinationValidation {

    private Card card;

    protected void interact(MoveWithTableauStackAsDestinationController moveWithTableauStackAsDestinationController) {
        assert moveWithTableauStackAsDestinationController != null;
        if (validateOrigin(moveWithTableauStackAsDestinationController)) {
            card = moveWithTableauStackAsDestinationController.pop();
            if (validateDestination(card, moveWithTableauStackAsDestinationController)) {
                moveWithTableauStackAsDestinationController.push(card);
                new GameView(moveWithTableauStackAsDestinationController).show();
                new MenuView().show();
            }
        }
    }

    @Override
    protected void pushBack(MoveWithDestinationValidationController moveWithDestinationValidationController) {
        assert moveWithDestinationValidationController != null;
        assert card != null;
        moveWithDestinationValidationController.pushBack(card);
    }
}
