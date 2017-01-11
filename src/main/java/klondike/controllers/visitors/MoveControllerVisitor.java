package klondike.controllers.visitors;

import klondike.controllers.move.*;

public interface MoveControllerVisitor {

    void visit(MoveController moveController);

    void visit(MoveFromFoundationToTableauStackController moveFromFoundationToTableauStackController);

    void visit(MoveFromTableauStackToFoundationController moveFromTableauStackToFoundationController);

    void visit(MoveFromTableauStackToTableauStackController moveFromTableauStackToTableauStackController);

    void visit(MoveFromWasteToTableauStackController moveFromWasteToTableauStackController);
}
