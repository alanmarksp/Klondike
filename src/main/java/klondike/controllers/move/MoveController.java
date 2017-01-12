package klondike.controllers.move;

import klondike.controllers.ActionController;
import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.views.console.ErrorView;

public interface MoveController extends ActionController {

    void accept(MoveControllerVisitor moveControllerVisitor);

    void accept(ErrorView errorView);

    void move();

    Error validateMove();

    int getNumTableauStacks();

    boolean isGameOver();

    void finishGame();
}
