package klondike.views.console.move;

import klondike.controllers.move.MoveFromWasteToTableauStackController;
import klondike.utils.LimitedIntDialog;

public class MoveFromWasteToTableauStackView extends MoveWithTableauStackAsDestination {

    public void interact(MoveFromWasteToTableauStackController moveFromWasteToTableauStackController) {
        assert moveFromWasteToTableauStackController != null;
        prepareController(moveFromWasteToTableauStackController);
        super.interact(moveFromWasteToTableauStackController);
    }

    private void prepareController(MoveFromWasteToTableauStackController moveFromWasteToTableauStackController) {
        assert moveFromWasteToTableauStackController != null;
        int numTableauStacks = moveFromWasteToTableauStackController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("En que escalera?", numTableauStacks).read() - 1;
        moveFromWasteToTableauStackController.setDestination(tableauStackIndex);
    }
}
