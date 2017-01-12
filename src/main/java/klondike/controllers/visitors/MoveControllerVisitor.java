package klondike.controllers.visitors;

import klondike.controllers.move.*;

public interface MoveControllerVisitor {

    void visit(MoveFromDeckToWasteController moveFromDeckToWasteController);

    void visit(MoveFromFoundationToTableauStackController moveFromFoundationToTableauStackController);

    void visit(MoveFromTableauStackToFoundationController moveFromTableauStackToFoundationController);

    void visit(MoveFromTableauStackToTableauStackController moveFromTableauStackToTableauStackController);

    void visit(MoveFromWasteToDeckController moveFromWasteToDeckController);

    void visit(MoveFromWasteToFoundationController moveFromWasteToFoundationController);

    void visit(MoveFromWasteToTableauStackController moveFromWasteToTableauStackController);
}
