package klondike.views.console.move;

import klondike.controllers.Error;
import klondike.controllers.move.MoveFromTableauStackToFoundationController;
import klondike.models.Card;
import klondike.utils.LimitedIntDialog;
import klondike.views.console.ErrorView;
import klondike.views.console.MenuView;
import klondike.views.console.models.GameView;

public class MoveFromTableauStackToFoundationView {

    public void interact(MoveFromTableauStackToFoundationController moveFromTableauStackToFoundationController) {
        prepareController(moveFromTableauStackToFoundationController);
        Error error = moveFromTableauStackToFoundationController.validateOrigin();
        if (error != null) {
            new ErrorView(error).interact(moveFromTableauStackToFoundationController);
            return;
        }
        Card card = moveFromTableauStackToFoundationController.pop();
        moveFromTableauStackToFoundationController.setDestination(card.getSuit());
        error = moveFromTableauStackToFoundationController.validateDestination(card);
        if (error != null) {
            moveFromTableauStackToFoundationController.pushBack(card);
            new ErrorView(error).interact(moveFromTableauStackToFoundationController);
            return;
        }
        moveFromTableauStackToFoundationController.push(card);
        new GameView(moveFromTableauStackToFoundationController).show();
        if (moveFromTableauStackToFoundationController.isGameOver()) {
            moveFromTableauStackToFoundationController.finishGame();
        } else {
            new MenuView().show();
        }
    }

    private void prepareController(MoveFromTableauStackToFoundationController moveFromTableauStackToFoundationController) {
        int numTableauStacks = moveFromTableauStackToFoundationController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("De que escalera?", numTableauStacks).read() - 1;
        moveFromTableauStackToFoundationController.setOrigin(tableauStackIndex);
    }
}
