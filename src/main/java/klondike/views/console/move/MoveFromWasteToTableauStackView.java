package klondike.views.console.move;

import klondike.controllers.move.MoveFromWasteToTableauStackController;
import klondike.utils.LimitedIntDialog;

public class MoveFromWasteToTableauStackView extends MoveWithTableauStackAsDestination {

    public void interact(MoveFromWasteToTableauStackController moveFromWasteToTableauStackController) {
        prepareController(moveFromWasteToTableauStackController);
        super.interact(moveFromWasteToTableauStackController);
    }

    private void prepareController(MoveFromWasteToTableauStackController moveFromWasteToTableauStackController) {
        int numTableauStacks = moveFromWasteToTableauStackController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("En que escalera?", numTableauStacks).read() - 1;
        moveFromWasteToTableauStackController.setDestination(tableauStackIndex);
    }
}
