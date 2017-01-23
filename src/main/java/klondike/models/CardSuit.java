package klondike.models;

public interface CardSuit {

    String toString();

    boolean isSameColor(CardSuit suit);

    Color getColor();

}
