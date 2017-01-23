package klondike.views.console.models;

import klondike.models.Card;
import klondike.utils.IO;

public class CardView {

    private final Card card;

    private IO io = new IO();

    public CardView(Card card) {
        assert card != null;
        this.card = card;
    }

    public void show() {
        if (card.isFaceUp()) {
            io.write("[" + card.getValue() + "," + card.getSuit().toString().charAt(0) + "]");
        } else {
            io.write("[X,X]");
        }
    }
}
