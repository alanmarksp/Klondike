package klondike.views.console.move;

import klondike.controllers.move.MoveWithDestinationValidationController;
import klondike.controllers.move.MoveWithFoundationAsDestinationController;
import klondike.models.Card;
import klondike.views.console.MenuView;
import klondike.views.console.models.GameView;

public abstract class MoveWithFoundationAsDestination extends MoveWithDestinationValidation {

    private Card card;

    protected void interact(MoveWithFoundationAsDestinationController moveWithFoundationAsDestinationController) {
        if (validateOrigin(moveWithFoundationAsDestinationController)) {
            card = moveWithFoundationAsDestinationController.pop();
            moveWithFoundationAsDestinationController.setDestination(card.getSuit());
            if (validateDestination(card, moveWithFoundationAsDestinationController)) {
                moveWithFoundationAsDestinationController.push(card);
                new GameView(moveWithFoundationAsDestinationController).show();
                if (moveWithFoundationAsDestinationController.isGameOver()) {
                    moveWithFoundationAsDestinationController.finishGame();
                } else {
                    new MenuView().show();
                }
            }
        }
    }

    @Override
    protected void pushBack(MoveWithDestinationValidationController moveWithDestinationValidationController) {
        moveWithDestinationValidationController.pushBack(card);
    }
}
