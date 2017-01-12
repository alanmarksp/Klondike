package klondike.views.console;

import klondike.controllers.Error;
import klondike.controllers.local.move.*;
import klondike.controllers.move.MoveController;
import klondike.utils.IO;

public class ErrorView {

    private IO io = new IO();

    private Error error;

    public ErrorView(Error error) {
        this.error = error;
    }

    public void interact(MoveController moveController) {
        moveController.accept(this);
    }

    public void visit(MoveFromDeckToWasteController moveFromDeckToWasteController) {
        assert error == Error.EMPTY_STACK;

    }

    public void visit(MoveFromFoundationToTableauStackController moveFromFoundationToTableauStackController) {

    }

    public void visit(MoveFromTableauStackToFoundationController moveFromTableauStackToFoundationController) {

    }

    public void visit(MoveFromTableauStackToTableauStackController moveFromTableauStackToTableauStackController) {

    }

    public void visit(MoveFromWasteToDeckController moveFromWasteToDeckController) {

    }

    public void visit(MoveFromWasteToFoundationController moveFromWasteToFoundationController) {

    }

    public void visit(MoveFromWasteToTableauStackController moveFromWasteToTableauStackController) {
    }
}
