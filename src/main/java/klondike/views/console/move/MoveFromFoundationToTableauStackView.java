package klondike.views.console.move;

import klondike.controllers.Error;
import klondike.controllers.move.MoveFromFoundationToTableauStackController;
import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.utils.LimitedIntDialog;
import klondike.views.console.ErrorView;
import klondike.views.console.MenuView;
import klondike.views.console.models.GameView;

public class MoveFromFoundationToTableauStackView {

    public void interact(MoveFromFoundationToTableauStackController moveFromFoundationToTableauStackController) {
        prepareController(moveFromFoundationToTableauStackController);
        Error error = moveFromFoundationToTableauStackController.validateOrigin();
        if (error != null) {
            new ErrorView(error).interact(moveFromFoundationToTableauStackController);
            return;
        }
        Card card = moveFromFoundationToTableauStackController.pop();
        error = moveFromFoundationToTableauStackController.validateDestination(card);
        if (error != null) {
            moveFromFoundationToTableauStackController.pushBack(card);
            new ErrorView(error).interact(moveFromFoundationToTableauStackController);
            return;
        }
        moveFromFoundationToTableauStackController.push(card);
        new GameView(moveFromFoundationToTableauStackController).show();
        new MenuView().show();
    }

    private void prepareController(MoveFromFoundationToTableauStackController moveFromFoundationToTableauStackController) {
        int cardSuitIndex = new LimitedIntDialog("De que palo?", CardSuit.values().length).read() - 1;
        moveFromFoundationToTableauStackController.setOrigin(CardSuit.values()[cardSuitIndex]);
        int numTableauStacks = moveFromFoundationToTableauStackController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("En que escalera?", numTableauStacks).read() - 1;
        moveFromFoundationToTableauStackController.setDestination(tableauStackIndex);
    }
}
