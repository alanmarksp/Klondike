package klondike.views.console.models;

import klondike.models.Card;
import klondike.utils.IO;

import java.util.Stack;

public class DeckView {

    private IO io = new IO();

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
