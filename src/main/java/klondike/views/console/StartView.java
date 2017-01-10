package klondike.views.console;

import klondike.controllers.local.StartController;

public class StartView {

    public void interact(StartController startController) {
        new TableView(startController.getGame()).show();
        new MenuView().show();
        startController.start();
    }
}
