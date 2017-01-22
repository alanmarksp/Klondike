package klondike.views.console.models;

import klondike.controllers.PresenterController;
import klondike.models.Card;

import java.util.Stack;

public class WasteView extends StackView {

    private int gameMode;

    public WasteView(PresenterController presenterController) {
        setCards(presenterController.getWaste());
        this.gameMode = presenterController.getGameMode();
        setTitle("Descarte: ");
    }

    @Override
    protected void showStack() {
        Stack<Card> waste = getCards();
        Stack<Card> tempCardsStack = new Stack<>();
        while (!waste.isEmpty() && tempCardsStack.size() < gameMode) {
            tempCardsStack.push(waste.pop());
        }
        while (!tempCardsStack.isEmpty()) {
            Card card = tempCardsStack.pop();
            showCard(card);
            waste.push(card);
        }
    }
}
