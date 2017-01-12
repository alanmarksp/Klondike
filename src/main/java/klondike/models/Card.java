package klondike.models;

public class Card {

    private CardValue value;

    private CardSuit suit;

    private CardState state;

    public Card(CardValue value, CardSuit suit) {
        assert value != null;
        assert suit != null;
        this.value = value;
        this.suit = suit;
        this.state = CardState.FACE_DOWN;
    }

    public CardValue getValue() {
        return value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return state == CardState.FACE_UP;
    }

    public Card flipUp() {
        state = CardState.FACE_UP;
        return this;
    }

    public Card flipDown() {
        state = CardState.FACE_DOWN;
        return this;
    }

}
