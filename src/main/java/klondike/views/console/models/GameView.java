package klondike.views.console.models;

import klondike.controllers.PresenterController;
import klondike.models.CardSuit;
import klondike.utils.IO;

public class GameView {

    private IO io = new IO();

    private PresenterController presenterController;

    public GameView(PresenterController presenterController) {
        assert presenterController != null;
        this.presenterController = presenterController;
    }

    public void show() {
        io.writeln("===========================");
        new DeckView(presenterController).show();
        new WasteView(presenterController).show();
        for (CardSuit cardSuit : presenterController.getCardSuiteValues()) {
            new FoundationView(presenterController, cardSuit).show();
        }
        for (int i = 0; i < presenterController.getNumTableauStacks(); i++) {
            new TableauStackView(presenterController, i).show();
        }
    }
}
