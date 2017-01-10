package klondike.models;

public enum CardSuit {

    DIAMONDS("oros", Color.RED),
    HEARTS("copas", Color.RED),
    SPADES("espadas", Color.BLACK),
    CLUBS("bastos", Color.BLACK);

    private String message;

    private Color color;

    CardSuit(String message, Color color) {
        this.message = message;
        this.color = color;
    }

    @Override
    public String toString() {
        return message;
    }

    public boolean isSameColor(CardSuit suit) {
        return this.color == suit.color;
    }

}
