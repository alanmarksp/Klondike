package klondike.controllers.move;

import klondike.controllers.ActionController;
import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;

public interface MoveController extends ActionController {

    void accept(MoveControllerVisitor moveControllerVisitor);

    void move();

    Error validateMove();

    int getNumTableauStacks();

    void finishGame();
}
