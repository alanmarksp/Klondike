package klondike.models;

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
        deck = new Stack<>();
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                deck.push(new Card(value, cardSuit));
            }
        }
        waste = new Stack<>();
        foundations = new HashMap<>();
        for (CardSuit value : CardSuit.values()) {
            foundations.put(value, new Stack<>());
        }
        tableau = new ArrayList<>();
        for (int i = 0; i < NUM_TABLEAU_STACKS; i++) {
            tableau.add(new Stack<>());
        }
        setTable();
    }

    public void gatherCards() {
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
        return foundations.get(cardSuit);
    }

    public Stack<Card> getTableauStack(int tableauStackIndex) {
        return tableau.get(tableauStackIndex);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static int getNumTableauStacks() {
        return NUM_TABLEAU_STACKS;
    }

    public static int getGameMode() {
        return GAME_MODE;
    }
}
