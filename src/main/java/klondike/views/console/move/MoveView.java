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
        moveFromWasteToDeckView = new MoveFromWasteToDeckView();
    }

    public void interact(MoveController moveController) {
        moveController.accept(this);
    }

    @Override
    public void visit(MoveFromDeckToWasteController moveFromDeckToWasteController) {
        moveFromDeckToWasteView.interact(moveFromDeckToWasteController);
    }

    @Override
    public void visit(MoveFromFoundationToTableauStackController moveFromFoundationToTableauStackController) {
        moveFromFoundationToTableauStackView.interact(moveFromFoundationToTableauStackController);
    }

    @Override
    public void visit(MoveFromTableauStackToFoundationController moveFromTableauStackToFoundationController) {
        moveFromTableauStackToFoundationView.interact(moveFromTableauStackToFoundationController);
    }

    @Override
    public void visit(MoveFromTableauStackToTableauStackController moveFromTableauStackToTableauStackController) {
        moveFromTableauStackToTableauStackView.interact(moveFromTableauStackToTableauStackController);
    }

    @Override
    public void visit(MoveFromWasteToDeckController moveFromWasteToDeckController) {
        moveFromWasteToDeckView.interact(moveFromWasteToDeckController);
    }

    @Override
    public void visit(MoveFromWasteToFoundationController moveFromWasteToFoundationController) {
        moveFromWasteToFoundationView.interact(moveFromWasteToFoundationController);
    }

    @Override
    public void visit(MoveFromWasteToTableauStackController moveFromWasteToTableauStackController) {
        moveFromWasteToTableauStackView.interact(moveFromWasteToTableauStackController);
    }
}
