package klondike.views.console;

import klondike.controllers.local.StartController;
import klondike.views.console.models.GameView;

public class StartView {

    public void interact(StartController startController) {
        assert startController != null;
        new GameView(startController).show();
        new MenuView().show();
        startController.start();
    }
}
