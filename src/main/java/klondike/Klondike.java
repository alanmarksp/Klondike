package klondike;

import klondike.controllers.ScenarioController;
import klondike.views.console.MainView;

public class Klondike {

    private Logic logic;

    private View view;

    private Klondike(Logic logic, View view) {
        assert logic != null;
        assert view != null;
        this.logic = logic;
        this.view = view;
    }

    public static void main(String[] args) {
        new Klondike(new klondike.controllers.local.Logic(), new MainView()).play();
    }

    private void play() {
        ScenarioController scenarioController;
        do {
            scenarioController = logic.getController();
            if (scenarioController != null) {
                view.interact(scenarioController);
            }
        } while (scenarioController != null);
    }

}
