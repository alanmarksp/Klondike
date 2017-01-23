package klondike.controllers.local;

import klondike.controllers.ScenarioController;
import klondike.models.Game;

public class Logic implements klondike.Logic {

    private Game game;

    private StartController startController;

    private GameController gameController;

    private ContinueController continueController;

    public Logic() {
        game = new Game();
        startController = new StartController(game);
        gameController = new GameController(game);
        continueController = new ContinueController(game);
    }

    @Override
    public ScenarioController getController() {
        switch (game.getState()) {
            case INITIAL:
                return startController;
            case IN_GAME:
                return gameController;
            case FINAL:
                return continueController;
            case EXIT:
            default:
                return null;
        }
    }
}
