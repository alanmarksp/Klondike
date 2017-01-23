package klondike.views.console.models;

import klondike.controllers.PresenterController;
import klondike.models.Card;

import java.util.Stack;

public class WasteView extends StackView {

    private int gameMode;

    public WasteView(PresenterController presenterController) {
        assert presenterController != null;
        setCards(presenterController.getWaste());
        this.gameMode = presenterController.getGameMode();
        setTitle("Descarte: ");
    }

    @Override
    protected void showStack() {
        Stack<Card> waste = getCards();
        Stack<Card> tempCardStack = new Stack<>();
        while (!waste.isEmpty() && tempCardStack.size() < gameMode) {
            tempCardStack.push(waste.pop());
        }
        while (!tempCardStack.isEmpty()) {
            Card card = tempCardStack.pop();
            showCard(card);
            waste.push(card);
        }
    }
}
