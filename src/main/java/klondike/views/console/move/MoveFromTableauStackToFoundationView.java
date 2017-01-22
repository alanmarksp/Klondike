package klondike.views.console.move;

import klondike.controllers.move.MoveFromTableauStackToFoundationController;
import klondike.models.Card;
import klondike.utils.LimitedIntDialog;

public class MoveFromTableauStackToFoundationView extends MoveWithFoundationAsDestination {

    private Card card;

    public void interact(MoveFromTableauStackToFoundationController moveFromTableauStackToFoundationController) {
        prepareController(moveFromTableauStackToFoundationController);
        super.interact(moveFromTableauStackToFoundationController);
    }

    private void prepareController(MoveFromTableauStackToFoundationController moveFromTableauStackToFoundationController) {
        int numTableauStacks = moveFromTableauStackToFoundationController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("De que escalera?", numTableauStacks).read() - 1;
        moveFromTableauStackToFoundationController.setOrigin(tableauStackIndex);
    }
}
