package klondike.views.console.move;

import klondike.controllers.move.MoveFromTableauStackToTableauStackController;
import klondike.controllers.move.MoveWithDestinationValidationController;
import klondike.models.Card;
import klondike.utils.IO;
import klondike.utils.LimitedIntDialog;
import klondike.views.console.MenuView;
import klondike.views.console.models.GameView;

import java.util.Stack;

public class MoveFromTableauStackToTableauStackView extends MoveWithDestinationValidation {

    private IO io = new IO();

    private Stack<Card> tempCardStack;

    public void interact(MoveFromTableauStackToTableauStackController moveFromTableauStackToTableauStackController) {
        prepareController(moveFromTableauStackToTableauStackController);
        if (validateOrigin(moveFromTableauStackToTableauStackController)) {
            tempCardStack = new Stack<>();
            for (int i = 0; i < moveFromTableauStackToTableauStackController.getNumCardsToMove(); i++) {
                tempCardStack.push(moveFromTableauStackToTableauStackController.pop());
            }
            if (validateDestination(tempCardStack.peek(), moveFromTableauStackToTableauStackController)) {
                while (!tempCardStack.isEmpty()) {
                    moveFromTableauStackToTableauStackController.push(tempCardStack.pop());
                }
                new GameView(moveFromTableauStackToTableauStackController).show();
                new MenuView().show();
            }
        }
    }

    private void prepareController(MoveFromTableauStackToTableauStackController moveFromTableauStackToTableauStackController) {
        int numTableauStacks = moveFromTableauStackToTableauStackController.getNumTableauStacks();
        int originTableauStackIndex = new LimitedIntDialog("De que escalera?", numTableauStacks).read() - 1;
        moveFromTableauStackToTableauStackController.setOrigin(originTableauStackIndex);
        moveFromTableauStackToTableauStackController.setNumCardsToMove(io.readInt("Cuantas cartas? "));
        int destinationTableauStackIndex = new LimitedIntDialog("En que escalera?", numTableauStacks).read() - 1;
        moveFromTableauStackToTableauStackController.setDestination(destinationTableauStackIndex);
    }

    @Override
    protected void pushBack(MoveWithDestinationValidationController moveWithDestinationValidationController) {
        while (!tempCardStack.isEmpty()) {
            moveWithDestinationValidationController.pushBack(tempCardStack.pop());
        }
    }
}
