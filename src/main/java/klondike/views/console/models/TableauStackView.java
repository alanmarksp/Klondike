package klondike.views.console.models;

import klondike.models.Card;
import klondike.utils.IO;

import java.util.Stack;

public class TableauStackView {

    private IO io = new IO();

    private Stack<Card> tableauStack;

    private int tableauStackIndex;

    public TableauStackView(Stack<Card> tableauStack, int tableauStackIndex) {
        this.tableauStack = tableauStack;
        this.tableauStackIndex = tableauStackIndex + 1;
    }

    public void show() {
        io.write("Escalera " + tableauStackIndex + ": ");
        if (tableauStack.isEmpty()) {
            io.writeln("<vacío>");
        } else {
            for (Card card : tableauStack) {
                if (card.isFaceUp() || card == tableauStack.lastElement()) {
                    new CardView(card).show();
                } else {
                    io.write("[");
                }
            }
            io.writeln();
        }
    }
}
