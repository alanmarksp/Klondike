package klondike.views.console.move;

import klondike.controllers.move.MoveFromFoundationToTableauStackController;
import klondike.models.CardSuit;
import klondike.utils.LimitedIntDialog;

public class MoveFromFoundationToTableauStackView extends MoveWithTableauStackAsDestination {

    public void interact(MoveFromFoundationToTableauStackController moveFromFoundationToTableauStackController) {
        assert moveFromFoundationToTableauStackController != null;
        prepareController(moveFromFoundationToTableauStackController);
        super.interact(moveFromFoundationToTableauStackController);
    }

    private void prepareController(MoveFromFoundationToTableauStackController moveFromFoundationToTableauStackController) {
        assert moveFromFoundationToTableauStackController != null;
        int cardSuitIndex = new LimitedIntDialog("De que palo?", CardSuit.values().length).read() - 1;
        moveFromFoundationToTableauStackController.setOrigin(CardSuit.values()[cardSuitIndex]);
        int numTableauStacks = moveFromFoundationToTableauStackController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("En que escalera?", numTableauStacks).read() - 1;
        moveFromFoundationToTableauStackController.setDestination(tableauStackIndex);
    }
}
