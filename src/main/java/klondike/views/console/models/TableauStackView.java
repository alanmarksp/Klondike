package klondike.views.console.models;

import klondike.controllers.PresenterController;
import klondike.models.Card;
import klondike.utils.ClosedInterval;
import klondike.utils.IO;

import java.util.Stack;

public class TableauStackView extends StackView {

    private IO io = new IO();

    public TableauStackView(PresenterController presenterController, int tableauStackIndex) {
        assert presenterController != null;
        assert new ClosedInterval(0, presenterController.getNumTableauStacks() - 1).includes(tableauStackIndex);
        setCards(presenterController.getTableauStack(tableauStackIndex));
        setTitle("Escalera " + (tableauStackIndex + 1) + ": ");
    }

    @Override
    protected void showStack() {
        Stack<Card> tableauStack = getCards();
        for (Card card : tableauStack) {
            if (card.isFaceUp() || card == tableauStack.lastElement()) {
                showCard(card);
            } else {
                io.write("[");
            }
        }
    }
}
