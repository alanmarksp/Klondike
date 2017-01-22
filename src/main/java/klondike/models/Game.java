package klondike.models;

import klondike.utils.ClosedInterval;

import java.util.*;

public class Game {

    private static final int NUM_TABLEAU_STACKS = 7;

    private static final int GAME_MODE = 3;

    private State state;

    private Stack<Card> deck;

    private Stack<Card> waste;

    private Map<CardSuit, Stack<Card>> foundations;

    private List<Stack<Card>> tableau;

    public Game() {
        state = State.INITIAL;
        waste = new Stack<>();
        initDeck();
        initFoundations();
        initTableau();
        setTable();
    }

    private void initDeck() {
        deck = new Stack<>();
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                deck.push(new Card(value, cardSuit));
            }
        }
    }

    private void initFoundations() {
        foundations = new HashMap<>();
        for (CardSuit value : CardSuit.values()) {
            foundations.put(value, new Stack<>());
        }
    }

    private void initTableau() {
        tableau = new ArrayList<>();
        for (int i = 0; i < NUM_TABLEAU_STACKS; i++) {
            tableau.add(new Stack<>());
        }
    }

    public static int getNumTableauStacks() {
        return NUM_TABLEAU_STACKS;
    }

    public static int getGameMode() {
        return GAME_MODE;
    }

    private void gatherCards() {
        gatherCardsFromStack(waste);
        foundations.forEach((cardSuit, foundation) -> gatherCardsFromStack(foundation));
        tableau.forEach(this::gatherCardsFromStack);
    }

    private void gatherCardsFromStack(Stack<Card> stack) {
        assert stack != null;
        while (!stack.isEmpty()) {
            deck.push(stack.pop().flipDown());
        }
    }

    private void setTable() {
        Collections.shuffle(deck);
        for (int i = 0; i < NUM_TABLEAU_STACKS; i++) {
            for (int j = NUM_TABLEAU_STACKS; j > i; j--) {
                tableau.get(i).push(deck.pop());
            }
            tableau.get(i).peek().flipUp();
        }
    }

    public void reset() {
        gatherCards();
        setTable();
    }

    public boolean isGameOver() {
        for (CardSuit cardSuit : CardSuit.values()) {
            if (foundations.get(cardSuit).size() != CardValue.values().length) {
                return false;
            }
        }
        return true;
    }

    public Stack<Card> getDeck() {
        return deck;
    }

    public Stack<Card> getWaste() {
        return waste;
    }

    public Stack<Card> getFoundation(CardSuit cardSuit) {
        assert cardSuit != null;
        return foundations.get(cardSuit);
    }

    public Stack<Card> getTableauStack(int tableauStackIndex) {
        assert new ClosedInterval(0, NUM_TABLEAU_STACKS - 1).includes(tableauStackIndex);
        return tableau.get(tableauStackIndex);
    }

    private Card pop(Stack<Card> stack) {
        assert stack != null;
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return null;
    }

    public Card popFromDeck() {
        return pop(deck);
    }

    public Card popFromWaste() {
        return pop(waste);
    }

    public Card popFromFoundation(CardSuit cardSuit) {
        assert cardSuit != null;
        return pop(foundations.get(cardSuit));
    }

    public Card popFromTableauStack(int tableauStackIndex) {
        assert new ClosedInterval(0, NUM_TABLEAU_STACKS - 1).includes(tableauStackIndex);
        return pop(tableau.get(tableauStackIndex));
    }

    public void pushToDeck(Card card) {
        assert card != null;
        deck.push(card);
    }

    public void pushToWaste(Card card) {
        assert card != null;
        waste.push(card);
    }

    public void pushToFoundation(Card card, CardSuit cardSuit) {
        assert card != null;
        assert cardSuit != null;
        foundations.get(cardSuit).push(card);
    }

    public void pushToTableauStack(Card card, int tableauStackIndex) {
        assert card != null;
        assert new ClosedInterval(0, NUM_TABLEAU_STACKS - 1).includes(tableauStackIndex);
        tableau.get(tableauStackIndex).push(card);
    }

    public boolean isCardOnTabelauStackFacedUp(int tableauStackIndex) {
        assert new ClosedInterval(0, NUM_TABLEAU_STACKS - 1).includes(tableauStackIndex);
        return tableau.get(tableauStackIndex).peek().isFaceUp();
    }

    public void flipUp(int tableauStackIndex) {
        assert new ClosedInterval(0, NUM_TABLEAU_STACKS - 1).includes(tableauStackIndex);
        tableau.get(tableauStackIndex).peek().flipUp();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
