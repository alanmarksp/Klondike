package klondike.views.console.models;

import klondike.models.Card;
import klondike.views.console.BaseView;

import java.util.Stack;

public class DeckView extends BaseView {

    private Stack<Card> deck;

    public DeckView(Stack<Card> deck) {
        this.deck = deck;
    }

    public void show() {
        io.write("Baraja: ");
        if (deck.isEmpty()) {
            io.writeln("<vacío>");
        } else {
            new CardView(deck.peek()).show();
            io.writeln();
        }
    }
}
