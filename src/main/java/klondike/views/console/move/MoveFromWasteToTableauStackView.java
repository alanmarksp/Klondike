package klondike.views.console.move;

import klondike.controllers.Error;
import klondike.controllers.move.MoveFromWasteToTableauStackController;
import klondike.models.Card;
import klondike.utils.LimitedIntDialog;
import klondike.views.console.ErrorView;
import klondike.views.console.MenuView;
import klondike.views.console.models.GameView;

public class MoveFromWasteToTableauStackView {

    public void interact(MoveFromWasteToTableauStackController moveFromWasteToTableauStackController) {
        prepareController(moveFromWasteToTableauStackController);
        Error error = moveFromWasteToTableauStackController.validateOrigin();
        if (error != null) {
            new ErrorView(error).interact(moveFromWasteToTableauStackController);
            return;
        }
        Card card = moveFromWasteToTableauStackController.pop();
        error = moveFromWasteToTableauStackController.validateDestination(card);
        if (error != null) {
            moveFromWasteToTableauStackController.pushBack(card);
            new ErrorView(error).interact(moveFromWasteToTableauStackController);
            return;
        }
        moveFromWasteToTableauStackController.push(card);
        new GameView(moveFromWasteToTableauStackController).show();
        if (moveFromWasteToTableauStackController.isGameOver()) {
            moveFromWasteToTableauStackController.finishGame();
        } else {
            new MenuView().show();
        }
    }

    private void prepareController(MoveFromWasteToTableauStackController moveFromWasteToTableauStackController) {
        int numTableauStacks = moveFromWasteToTableauStackController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("En que escalera?", numTableauStacks).read() - 1;
        moveFromWasteToTableauStackController.setDestination(tableauStackIndex);
    }
}
