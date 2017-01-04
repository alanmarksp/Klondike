package klondike.controllers.local;

import klondike.models.Game;
import klondike.models.State;

abstract class Controller {

    private Game game;

    Controller(Game game) {
        assert game != null;
        this.game = game;
    }

    State getState() {
        return game.getState();
    }

    void setState(State state) {
        game.setState(state);
    }

    void reset() {
        game.reset();
    }
}
