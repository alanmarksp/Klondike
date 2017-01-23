package klondike.views.console.move;

import klondike.controllers.move.MoveFromFoundationToTableauStackController;
import klondike.models.CardSuit;
import klondike.utils.LimitedIntDialog;

import java.util.List;

public class MoveFromFoundationToTableauStackView extends MoveWithTableauStackAsDestination {

    public void interact(MoveFromFoundationToTableauStackController moveFromFoundationToTableauStackController) {
        assert moveFromFoundationToTableauStackController != null;
        prepareController(moveFromFoundationToTableauStackController);
        super.interact(moveFromFoundationToTableauStackController);
    }

    private void prepareController(MoveFromFoundationToTableauStackController moveFromFoundationToTableauStackController) {
        assert moveFromFoundationToTableauStackController != null;
        List<CardSuit> cardSuitValues = moveFromFoundationToTableauStackController.getCardSuiteValues();
        int cardSuitIndex = new LimitedIntDialog("De que palo?", cardSuitValues.size()).read() - 1;
        moveFromFoundationToTableauStackController.setOrigin(cardSuitValues.get(cardSuitIndex));
        int numTableauStacks = moveFromFoundationToTableauStackController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("En que escalera?", numTableauStacks).read() - 1;
        moveFromFoundationToTableauStackController.setDestination(tableauStackIndex);
    }
}
