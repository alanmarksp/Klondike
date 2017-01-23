package klondike.views.console.models;

import klondike.models.Card;
import klondike.utils.IO;

import java.util.Stack;

public abstract class StackView {

    private IO io = new IO();

    private Stack<Card> cards;

    private String title;

    protected void setTitle(String title) {
        assert title != null;
        this.title = title;
    }

    public void show() {
        io.write(title);
        if (cards.isEmpty()) {
            io.writeln("<vacío>");
        } else {
            showStack();
            io.writeln();
        }
    }

    protected void showStack() {
        showCard(getCards().peek());
    }

    protected void showCard(Card card) {
        assert card != null;
        new CardView(card).show();
    }

    protected Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        assert cards != null;
        this.cards = cards;
    }
}
