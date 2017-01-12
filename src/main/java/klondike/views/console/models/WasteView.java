package klondike.views.console.models;

import klondike.models.Card;
import klondike.utils.IO;

import java.util.Stack;

public class WasteView {

    private IO io = new IO();

    private Stack<Card> waste;

    private int gameMode;

    public WasteView(Stack<Card> waste, int gameMode) {
        this.waste = waste;
        this.gameMode = gameMode;
    }

    public void show() {
        io.write("Descarte: ");
        if (waste.isEmpty()) {
            io.writeln("<vacío>");
        } else {
            Stack<Card> cards = new Stack<>();
            while (!waste.isEmpty() && cards.size() < gameMode) {
                cards.push(waste.pop());
            }
            while (!cards.isEmpty()) {
                Card card = cards.pop();
                new CardView(card).show();
                waste.push(card);
            }
            io.writeln();
        }
    }
}
