package klondike.views.console;

import klondike.controllers.local.StartController;
import klondike.views.console.models.GameView;

public class StartView {

    public void interact(StartController startController) {
        new GameView(startController).show();
        new MenuView().show();
        startController.start();
    }
}
