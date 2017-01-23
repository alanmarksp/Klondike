package klondike.views.console;

import klondike.controllers.local.StartController;
import klondike.models.GameMode;
import klondike.utils.IO;
import klondike.utils.LimitedIntDialog;
import klondike.views.console.models.GameView;

public class StartView {

    private IO io = new IO();

    public void interact(StartController startController) {
        assert startController != null;
        showStartMenu();
        int option = new LimitedIntDialog("Opción?", GameMode.values().length).read() - 1;
        startController.start(GameMode.values()[option]);
        new GameView(startController).show();
        new MenuView().show();
    }

    private void showStartMenu() {
        io.writeln("---------------------------");
        io.writeln("1. Jugar con baraja española");
        io.writeln("2. Jugar con baraja francesa");
    }
}
