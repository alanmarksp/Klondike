package klondike.views.console.move;

import klondike.controllers.Error;
import klondike.controllers.move.MoveFromWasteToFoundationController;
import klondike.models.Card;
import klondike.views.console.ErrorView;
import klondike.views.console.MenuView;
import klondike.views.console.models.GameView;

public class MoveFromWasteToFoundationView {

    public void interact(MoveFromWasteToFoundationController moveFromWasteToFoundationController) {
        Error error = moveFromWasteToFoundationController.validateOrigin();
        if (error != null) {
            new ErrorView(error).interact(moveFromWasteToFoundationController);
            return;
        }
        Card card = moveFromWasteToFoundationController.pop();
        moveFromWasteToFoundationController.setDestination(card.getSuit());
        error = moveFromWasteToFoundationController.validateDestination(card);
        if (error != null) {
            moveFromWasteToFoundationController.pushBack(card);
            new ErrorView(error).interact(moveFromWasteToFoundationController);
            return;
        }
        moveFromWasteToFoundationController.push(card);
        new GameView(moveFromWasteToFoundationController).show();
        if (moveFromWasteToFoundationController.isGameOver()) {
            moveFromWasteToFoundationController.finishGame();
        } else {
            new MenuView().show();
        }
    }
}
