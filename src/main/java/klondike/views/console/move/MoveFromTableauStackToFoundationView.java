package klondike.views.console.move;

import klondike.controllers.move.MoveFromTableauStackToFoundationController;
import klondike.models.Card;
import klondike.utils.LimitedIntDialog;

public class MoveFromTableauStackToFoundationView extends MoveWithFoundationAsDestination {

    private Card card;

    public void interact(MoveFromTableauStackToFoundationController moveFromTableauStackToFoundationController) {
        assert moveFromTableauStackToFoundationController != null;
        prepareController(moveFromTableauStackToFoundationController);
        super.interact(moveFromTableauStackToFoundationController);
    }

    private void prepareController(MoveFromTableauStackToFoundationController moveFromTableauStackToFoundationController) {
        assert moveFromTableauStackToFoundationController != null;
        int numTableauStacks = moveFromTableauStackToFoundationController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("De que escalera?", numTableauStacks).read() - 1;
        moveFromTableauStackToFoundationController.setOrigin(tableauStackIndex);
    }
}
