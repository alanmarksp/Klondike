package klondike.views.console;

import klondike.controllers.Action;
import klondike.controllers.GameController;

public class GameView {

    private final ActionView actionView;

    GameView() {
        actionView = new ActionView();
    }

    void interact(GameController gameController) {
        actionView.interact(gameController.getActionController(Action.values()[new MenuView().getOption()]));
    }
}
