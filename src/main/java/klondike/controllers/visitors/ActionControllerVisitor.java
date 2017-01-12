package klondike.controllers.visitors;

import klondike.controllers.ExitGameController;
import klondike.controllers.FlipTableauCardController;
import klondike.controllers.move.MoveController;

public interface ActionControllerVisitor {

    void visit(MoveController moveController);

    void visit(FlipTableauCardController flipTableauCardController);

    void visit(ExitGameController exitGameController);
}
