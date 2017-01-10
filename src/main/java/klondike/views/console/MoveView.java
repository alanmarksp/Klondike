package klondike.views.console;

import klondike.controllers.Error;
import klondike.controllers.*;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.CardSuit;
import klondike.utils.LimitedIntDialog;

public class MoveView extends BaseView implements MoveControllerVisitor {

    public void interact(MoveController moveController) {
        moveController.accept(this);
    }

    private void move(MoveController moveController) {
        Error error = moveController.validateMove();
        if (error == null) {
            moveController.move();
            new TableView(moveController.getGame()).show();
            if (moveController.isGameOver()) {
                moveController.finishGame();
            } else {
                new MenuView().show();
            }
        } else {
            io.writeln(error.toString());
        }
    }

    @Override
    public void visit(MoveController moveController) {
        move(moveController);
    }

    @Override
    public void visit(MoveFromFoundationToTableauStackController moveFromFoundationToTableauStackController) {
        int cardSuitIndex = new LimitedIntDialog("De que palo?", CardSuit.values().length).read() - 1;
        moveFromFoundationToTableauStackController.setOrigin(CardSuit.values()[cardSuitIndex]);
        int numTableauStacks = moveFromFoundationToTableauStackController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("En que escalera?", numTableauStacks).read() - 1;
        moveFromFoundationToTableauStackController.setDestination(tableauStackIndex);
        move(moveFromFoundationToTableauStackController);
    }

    @Override
    public void visit(MoveFromTableauStackToFoundationController moveFromTableauStackToFoundationController) {
        int numTableauStacks = moveFromTableauStackToFoundationController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("De que escalera?", numTableauStacks).read() - 1;
        moveFromTableauStackToFoundationController.setOrigin(tableauStackIndex);
        move(moveFromTableauStackToFoundationController);
    }

    @Override
    public void visit(MoveFromTableauStackToTableauStackController moveFromTableauStackToTableauStackController) {
        int numTableauStacks = moveFromTableauStackToTableauStackController.getNumTableauStacks();
        int originTableauStackIndex = new LimitedIntDialog("De que escalera?", numTableauStacks).read() - 1;
        moveFromTableauStackToTableauStackController.setOrigin(originTableauStackIndex);
        moveFromTableauStackToTableauStackController.setNumCardsToMove(io.readInt("Cuantas cartas? "));
        int destinationTableauStackIndex = new LimitedIntDialog("En que escalera?", numTableauStacks).read() - 1;
        moveFromTableauStackToTableauStackController.setDestination(destinationTableauStackIndex);
        move(moveFromTableauStackToTableauStackController);
    }

    @Override
    public void visit(MoveFromWasteToTableauStackController moveFromWasteToTableauStackController) {
        int numTableauStacks = moveFromWasteToTableauStackController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("En que escalera?", numTableauStacks).read() - 1;
        moveFromWasteToTableauStackController.setDestination(tableauStackIndex);
        move(moveFromWasteToTableauStackController);
    }
}
