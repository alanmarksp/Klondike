package klondike.views.console;

import klondike.models.Card;

public class CardView extends BaseView {

    private final Card card;

    public CardView(Card card) {
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
