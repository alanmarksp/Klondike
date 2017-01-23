package klondike.models;

public enum SpanishCardSuit implements CardSuit {

    DIAMONDS("oros", Color.OROS),
    HEARTS("copas", Color.COPAS),
    SPADES("espadas", Color.ESPADAS),
    CLUBS("bastos", Color.BASTOS);

    private String message;

    private Color color;

    SpanishCardSuit(String message, Color color) {
        this.message = message;
        this.color = color;
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public boolean isSameColor(CardSuit suit) {
        return this.color == suit.getColor();
    }

    @Override
    public Color getColor() {
        return color;
    }

}
