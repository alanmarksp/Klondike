package klondike.views.console.move;

import klondike.controllers.move.*;
import klondike.controllers.visitors.MoveControllerVisitor;

public class MoveView implements MoveControllerVisitor {

    private MoveFromDeckToWasteView moveFromDeckToWasteView;

    private MoveFromFoundationToTableauStackView moveFromFoundationToTableauStackView;

    private MoveFromTableauStackToFoundationView moveFromTableauStackToFoundationView;

    private MoveFromTableauStackToTableauStackView moveFromTableauStackToTableauStackView;

    private MoveFromWasteToDeckView moveFromWasteToDeckView;

    private MoveFromWasteToFoundationView moveFromWasteToFoundationView;

    private MoveFromWasteToTableauStackView moveFromWasteToTableauStackView;

    public MoveView() {
        moveFromDeckToWasteView = new MoveFromDeckToWasteView();
        moveFromFoundationToTableauStackView = new MoveFromFoundationToTableauStackView();
        moveFromTableauStackToFoundationView = new MoveFromTableauStackToFoundationView();
        moveFromTableauStackToTableauStackView = new MoveFromTableauStackToTableauStackView();
        moveFromWasteToDeckView = new MoveFromWasteToDeckView();
        moveFromWasteToFoundationView = new MoveFromWasteToFoundationView();
        moveFromWasteToTableauStackView = new MoveFromWasteToTableauStackView();
    }

    public void interact(MoveController moveController) {
        assert moveController != null;
        moveController.accept(this);
    }

    @Override
    public void visit(MoveFromDeckToWasteController moveFromDeckToWasteController) {
        assert moveFromDeckToWasteController != null;
        moveFromDeckToWasteView.interact(moveFromDeckToWasteController);
    }

    @Override
    public void visit(MoveFromFoundationToTableauStackController moveFromFoundationToTableauStackController) {
        assert moveFromFoundationToTableauStackController != null;
        moveFromFoundationToTableauStackView.interact(moveFromFoundationToTableauStackController);
    }

    @Override
    public void visit(MoveFromTableauStackToFoundationController moveFromTableauStackToFoundationController) {
        assert moveFromTableauStackToFoundationController != null;
        moveFromTableauStackToFoundationView.interact(moveFromTableauStackToFoundationController);
    }

    @Override
    public void visit(MoveFromTableauStackToTableauStackController moveFromTableauStackToTableauStackController) {
        assert moveFromTableauStackToTableauStackController != null;
        moveFromTableauStackToTableauStackView.interact(moveFromTableauStackToTableauStackController);
    }

    @Override
    public void visit(MoveFromWasteToDeckController moveFromWasteToDeckController) {
        assert moveFromWasteToDeckController != null;
        moveFromWasteToDeckView.interact(moveFromWasteToDeckController);
    }

    @Override
    public void visit(MoveFromWasteToFoundationController moveFromWasteToFoundationController) {
        assert moveFromWasteToFoundationController != null;
        moveFromWasteToFoundationView.interact(moveFromWasteToFoundationController);
    }

    @Override
    public void visit(MoveFromWasteToTableauStackController moveFromWasteToTableauStackController) {
        assert moveFromWasteToTableauStackController != null;
        moveFromWasteToTableauStackView.interact(moveFromWasteToTableauStackController);
    }
}
