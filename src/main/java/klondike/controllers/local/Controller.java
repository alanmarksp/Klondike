package klondike.controllers.local;

import klondike.models.Game;
import klondike.models.State;

public abstract class Controller implements klondike.controllers.Controller {

    private Game game;

    protected Controller(Game game) {
        assert game != null;
        this.game = game;
    }

    protected State getState() {
        return game.getState();
    }

    protected void setState(State state) {
        game.setState(state);
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public int getGameMode() {
        return Game.getGameMode();
    }

    void reset() {
        game.reset();
    }
}
