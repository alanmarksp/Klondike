package klondike.models;

public enum FrenchCardSuit implements CardSuit {

    DIAMONDS("oros", Color.RED),
    HEARTS("copas", Color.RED),
    SPADES("espadas", Color.BLACK),
    CLUBS("bastos", Color.BLACK);

    private String message;

    private Color color;

    FrenchCardSuit(String message, Color color) {
        this.message = message;
        this.color = color;
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public boolean isSameColor(CardSuit suit) {
        return this == suit;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
