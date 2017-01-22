package klondike.views.console.move;

import klondike.controllers.Error;
import klondike.controllers.move.MoveFromTableauStackToTableauStackController;
import klondike.models.Card;
import klondike.utils.IO;
import klondike.utils.LimitedIntDialog;
import klondike.views.console.ErrorView;
import klondike.views.console.MenuView;
import klondike.views.console.models.GameView;

import java.util.Stack;

public class MoveFromTableauStackToTableauStackView {

    private IO io = new IO();

    public void interact(MoveFromTableauStackToTableauStackController moveFromTableauStackToTableauStackController) {
        prepareController(moveFromTableauStackToTableauStackController);
        Error error = moveFromTableauStackToTableauStackController.validateOrigin();
        if (error != null) {
            new ErrorView(error).interact(moveFromTableauStackToTableauStackController);
            return;
        }
        Stack<Card> tempCardStack = new Stack<>();
        for (int i = 0; i < moveFromTableauStackToTableauStackController.getNumCardsToMove(); i++) {
            tempCardStack.push(moveFromTableauStackToTableauStackController.pop());
        }
        error = moveFromTableauStackToTableauStackController.validateDestination(tempCardStack.peek());
        if (error != null) {
            while (!tempCardStack.isEmpty()) {
                moveFromTableauStackToTableauStackController.pushBack(tempCardStack.pop());
            }
            new ErrorView(error).interact(moveFromTableauStackToTableauStackController);
            return;
        }
        while (!tempCardStack.isEmpty()) {
            moveFromTableauStackToTableauStackController.push(tempCardStack.pop());
        }
        new GameView(moveFromTableauStackToTableauStackController).show();
        new MenuView().show();
    }

    private void prepareController(MoveFromTableauStackToTableauStackController moveFromTableauStackToTableauStackController) {
        int numTableauStacks = moveFromTableauStackToTableauStackController.getNumTableauStacks();
        int originTableauStackIndex = new LimitedIntDialog("De que escalera?", numTableauStacks).read() - 1;
        moveFromTableauStackToTableauStackController.setOrigin(originTableauStackIndex);
        moveFromTableauStackToTableauStackController.setNumCardsToMove(io.readInt("Cuantas cartas? "));
        int destinationTableauStackIndex = new LimitedIntDialog("En que escalera?", numTableauStacks).read() - 1;
        moveFromTableauStackToTableauStackController.setDestination(destinationTableauStackIndex);
    }
}
