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

    private GameMode gameMode;

    public Game() {
        state = State.INITIAL;
        waste = new Stack<>();
        deck = new Stack<>();
        foundations = new HashMap<>();
        initTableau();
    }

    public static int getNumTableauStacks() {
        return NUM_TABLEAU_STACKS;
    }

    public static int getGameMode() {
        return GAME_MODE;
    }

    public void setTable(GameMode gameMode) {
        this.gameMode = gameMode;
        if (gameMode == GameMode.SPANISH) {
            setSpanishTable();
        } else {
            setFrenchTable();
        }
    }

    private void setSpanishTable() {
        gatherCards();
        deck.clear();
        initSpanishFoundations();
        for (SpanishCardSuit cardSuit : SpanishCardSuit.values()) {
            for (SpanishCardValue value : SpanishCardValue.values()) {
                deck.push(new Card(value, cardSuit));
            }
        }
        setTable();
    }

    private void setFrenchTable() {
        gatherCards();
        deck.clear();
        initFrenchFoundations();
        for (FrenchCardSuit cardSuit : FrenchCardSuit.values()) {
            for (FrenchCardValue value : FrenchCardValue.values()) {
                deck.push(new Card(value, cardSuit));
            }
        }
        setTable();
    }

    private void initSpanishFoundations() {
        foundations.clear();
        for (SpanishCardSuit value : SpanishCardSuit.values()) {
            foundations.put(value, new Stack<>());
        }
    }

    private void initFrenchFoundations() {
        foundations.clear();
        for (FrenchCardSuit value : FrenchCardSuit.values()) {
            foundations.put(value, new Stack<>());
        }
    }

    private void initTableau() {
        tableau = new ArrayList<>();
        for (int i = 0; i < NUM_TABLEAU_STACKS; i++) {
            tableau.add(new Stack<>());
        }
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

    public boolean isGameOver() {
        if (gameMode == GameMode.SPANISH) {
            return isSpanishGameOver();
        } else {
            return isFrenchGameOver();
        }
    }

    private boolean isSpanishGameOver() {
        for (SpanishCardSuit cardSuit : SpanishCardSuit.values()) {
            if (foundations.get(cardSuit).size() != SpanishCardValue.values().length) {
                return false;
            }
        }
        return true;
    }

    private boolean isFrenchGameOver() {
        for (FrenchCardSuit cardSuit : FrenchCardSuit.values()) {
            if (foundations.get(cardSuit).size() != FrenchCardValue.values().length) {
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

    public boolean isDeckEmpty() {
        return deck.isEmpty();
    }

    public boolean isWasteEmpty() {
        return waste.isEmpty();
    }

    public boolean isFoundationEmpty(CardSuit cardSuit) {
        assert cardSuit != null;
        return foundations.get(cardSuit).isEmpty();
    }

    public boolean isTableauStackEmpty(int tableauStackIndex) {
        assert new ClosedInterval(0, NUM_TABLEAU_STACKS - 1).includes(tableauStackIndex);
        return tableau.get(tableauStackIndex).isEmpty();
    }

    public boolean isCardOnTabelauStackFacedUp(int tableauStackIndex) {
        assert new ClosedInterval(0, NUM_TABLEAU_STACKS - 1).includes(tableauStackIndex);
        return tableau.get(tableauStackIndex).peek().isFaceUp();
    }

    public void flipUp(int tableauStackIndex) {
        assert new ClosedInterval(0, NUM_TABLEAU_STACKS - 1).includes(tableauStackIndex);
        tableau.get(tableauStackIndex).peek().flipUp();
    }

    public CardValue getCardValueFromFoundation(CardSuit cardSuit) {
        assert cardSuit != null;
        return foundations.get(cardSuit).peek().getValue();
    }

    public CardValue getCardValueFromTableauStack(int tableauStackIndex) {
        assert new ClosedInterval(0, NUM_TABLEAU_STACKS - 1).includes(tableauStackIndex);
        return tableau.get(tableauStackIndex).peek().getValue();
    }

    public CardSuit getCardSuitFromTableauStack(int tableauStackIndex) {
        assert new ClosedInterval(0, NUM_TABLEAU_STACKS - 1).includes(tableauStackIndex);
        return tableau.get(tableauStackIndex).peek().getSuit();
    }

    public int getDeckSize() {
        return deck.size();
    }

    public int getWasteSize() {
        return waste.size();
    }

    public int getTableauStackSize(int tableauStackIndex) {
        return tableau.get(tableauStackIndex).size();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Card peekWaste() {
        if (!waste.isEmpty()) {
            return waste.peek();
        }
        return null;
    }

    public Card peekFoundation(CardSuit cardSuit) {
        if (!foundations.get(cardSuit).isEmpty()) {
            return foundations.get(cardSuit).peek();
        }
        return null;
    }

    public Card peekTableauStack(int tableauStackIndex) {
        assert new ClosedInterval(0, NUM_TABLEAU_STACKS - 1).includes(tableauStackIndex);
        if (!tableau.get(tableauStackIndex).isEmpty()) {
            return tableau.get(tableauStackIndex).peek();
        }
        return null;
    }

    public List<CardSuit> getCardSuiteValues() {
        List<CardSuit> values = new ArrayList<>();
        if (gameMode == GameMode.SPANISH) {
            Collections.addAll(values, SpanishCardSuit.values());
        } else {
            Collections.addAll(values, FrenchCardSuit.values());
        }
        return values;
    }
}
