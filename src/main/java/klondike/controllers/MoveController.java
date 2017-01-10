package klondike.controllers;

import klondike.controllers.visitors.MoveControllerVisitor;

public interface MoveController extends ActionController {

    void accept(MoveControllerVisitor moveControllerVisitor);

    void move();

    Error validateMove();

    int getNumTableauStacks();

    boolean isGameOver();

    void finishGame();
}
