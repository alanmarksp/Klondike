package klondike.views.console.models;

import klondike.controllers.PresenterController;

public class DeckView extends StackView{

    public DeckView(PresenterController presenterController) {
        assert presenterController != null;
        setCards(presenterController.getDeck());
        setTitle("Baraja: ");
    }
}
