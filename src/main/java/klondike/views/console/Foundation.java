package klondike.views.console;

import klondike.models.Card;
import klondike.models.CardSuit;

import java.util.Stack;

public class Foundation extends BaseView {

    private Stack<Card> foundation;

    private CardSuit cardSuit;

    public Foundation(Stack<Card> foundation, CardSuit cardSuit) {
        this.foundation = foundation;
        this.cardSuit = cardSuit;
    }

    public void show() {
        io.write("Palo " + cardSuit + ": ");
        if (foundation.isEmpty()) {
            io.writeln("<vacío>");
        } else {
            new CardView(foundation.peek()).show();
            io.writeln();
        }
    }
}
