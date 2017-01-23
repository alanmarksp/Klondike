package klondike.controllers.local;

import klondike.controllers.PresenterController;
import klondike.models.*;
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

    protected Card popFromDeck() {
        return game.popFromDeck();
    }

    protected Card popFromWaste() {
        return game.popFromWaste();
    }

    protected Card popFromFoundation(CardSuit cardSuit) {
        assert cardSuit != null;
        return game.popFromFoundation(cardSuit);
    }

    protected Card popFromTableauStack(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return game.popFromTableauStack(tableauStackIndex);
    }

    protected void pushToDeck(Card card) {
        assert card != null;
        game.pushToDeck(card);
    }

    protected void pushToWaste(Card card) {
        assert card != null;
        game.pushToWaste(card);
    }

    protected void pushToFoundation(Card card, CardSuit cardSuit) {
        assert card != null;
        assert cardSuit != null;
        game.pushToFoundation(card, cardSuit);
    }

    protected void pushToTableauStack(Card card, int tableauStackIndex) {
        assert card != null;
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        game.pushToTableauStack(card, tableauStackIndex);
    }

    protected boolean isDeckEmpty() {
        return game.isDeckEmpty();
    }

    protected boolean isWasteEmpty() {
        return game.isWasteEmpty();
    }

    protected boolean isFoundationEmpty(CardSuit cardSuit) {
        assert cardSuit != null;
        return game.isFoundationEmpty(cardSuit);
    }

    protected boolean isTableauStackEmpty(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return game.isTableauStackEmpty(tableauStackIndex);
    }

    protected CardValue getCardValueFromFoundation(CardSuit cardSuit) {
        assert cardSuit != null;
        return game.getCardValueFromFoundation(cardSuit);
    }

    protected CardValue getCardValueFromTableauStack(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return game.getCardValueFromTableauStack(tableauStackIndex);
    }

    protected CardSuit getCardSuitFromTableauStack(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return game.getCardSuitFromTableauStack(tableauStackIndex);
    }

    protected int getDeckSize() {
        return game.getDeckSize();
    }

    protected int getWasteSize() {
        return game.getWasteSize();
    }

    protected int getTableauStackSize(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return game.getTableauStackSize(tableauStackIndex);
    }

    protected Card peekWaste() {
        return game.peekWaste();
    }

    protected Card peekFoundation(CardSuit cardSuit) {
        return game.peekFoundation(cardSuit);
    }

    protected Card peeKTableauStack(int tableauStackIndex) {
        return game.peekTableauStack(tableauStackIndex);
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
