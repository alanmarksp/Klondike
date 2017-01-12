package klondike.controllers.local;

import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.models.Game;
import klondike.models.State;

import java.util.Stack;

public abstract class BaseController implements klondike.controllers.BaseController {

    private Game game;

    protected BaseController(Game game) {
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
    public boolean isGameOver() {
        return game.isGameOver();
    }

    protected void reset() {
        game.reset();
    }

    protected Stack<Card> getTableauStack(int tableauStackIndex) {
        return game.getTableauStack(tableauStackIndex);
    }

    protected Stack<Card> getFoundation(CardSuit cardSuit) {
        return game.getFoundation(cardSuit);
    }
}
