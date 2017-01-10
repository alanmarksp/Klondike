package klondike.views.console;

import klondike.controllers.GameController;

class GameView {

    private final ActionView actionView;

    GameView() {
        actionView = new ActionView();
    }

    void interact(GameController gameController) {
        actionView.interact(gameController.getActionController(new MenuView().getOption()));
    }
}
