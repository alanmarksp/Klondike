package klondike.views.console.models;

import klondike.models.Card;
import klondike.views.console.BaseView;

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
