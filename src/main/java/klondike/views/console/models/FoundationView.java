package klondike.views.console.models;

import klondike.controllers.PresenterController;
import klondike.models.CardSuit;

public class FoundationView extends StackView {

    public FoundationView(PresenterController presenterController, CardSuit cardSuit) {
        setCards(presenterController.getFoundation(cardSuit));
        setTitle("Palo " + cardSuit + ": ");
    }
}
