package klondike.controllers.local;

import klondike.controllers.PresenterController;
import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.models.Game;
import klondike.models.State;
import klondike.utils.ClosedInterval;

import java.util.Stack;

public abstract class BaseController implements PresenterController {

    private Game game;

    protected BaseController(Game game) {
        assert game != null;
        this.game = game;
    }

    protected State getState() {
        return game.getState();
    }

    protected void setState(State state) {
        assert state != null;
        game.setState(state);
    }

    public boolean isGameOver() {
        return game.isGameOver();
    }

    protected void reset() {
        game.reset();
    }

    protected boolean isCardOnTabelauStackFacedUp(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return game.isCardOnTabelauStackFacedUp(tableauStackIndex);
    }

    protected void flipUp(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        game.flipUp(tableauStackIndex);
    }

    public Card popFromDeck() {
        return game.popFromDeck();
    }

    public Card popFromWaste() {
        return game.popFromWaste();
    }

    public Card popFromFoundation(CardSuit cardSuit) {
        assert cardSuit != null;
        return game.popFromFoundation(cardSuit);
    }

    public Card popFromTableauStack(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return game.popFromTableauStack(tableauStackIndex);
    }

    public void pushToDeck(Card card) {
        assert card != null;
        game.pushToDeck(card);
    }

    public void pushToWaste(Card card) {
        assert card != null;
        game.pushToWaste(card);
    }

    public void pushToFoundation(Card card, CardSuit cardSuit) {
        assert card != null;
        assert cardSuit != null;
        game.pushToFoundation(card, cardSuit);
    }

    public void pushToTableauStack(Card card, int tableauStackIndex) {
        assert card != null;
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        game.pushToTableauStack(card, tableauStackIndex);
    }

    @Override
    public Stack<Card> getDeck() {
        return game.getDeck();
    }

    @Override
    public Stack<Card> getWaste() {
        return game.getWaste();
    }

    @Override
    public Stack<Card> getFoundation(CardSuit cardSuit) {
        assert cardSuit != null;
        return game.getFoundation(cardSuit);
    }

    @Override
    public Stack<Card> getTableauStack(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return game.getTableauStack(tableauStackIndex);
    }

    @Override
    public int getGameMode() {
        return Game.getGameMode();
    }

    @Override
    public int getNumTableauStacks() {
        return Game.getNumTableauStacks();
    }
}
