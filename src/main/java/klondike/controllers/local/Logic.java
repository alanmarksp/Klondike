package klondike.controllers.local;

import klondike.controllers.ScenarioController;
import klondike.models.Game;

public class Logic implements klondike.Logic {

    private Game game;

    private PlayController playController;

    private ContinueController continueController;

    public Logic() {
        game = new Game();
        playController = new PlayController(game);
        continueController = new ContinueController(game);
    }

    @Override
    public ScenarioController getController() {
        switch (game.getState()) {
            case IN_GAME:
                return playController;
            case FINAL:
                return continueController;
            case EXIT:
            default:
                return null;
        }
    }
}
