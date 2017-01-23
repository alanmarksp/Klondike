package klondike.views.console.move;

import klondike.controllers.move.MoveFromWasteToFoundationController;

public class MoveFromWasteToFoundationView extends MoveWithFoundationAsDestination {

    public void interact(MoveFromWasteToFoundationController moveFromWasteToFoundationController) {
        assert moveFromWasteToFoundationController != null;
        super.interact(moveFromWasteToFoundationController);
    }
}
