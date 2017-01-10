package klondike.views.console;

import klondike.models.CardSuit;
import klondike.models.Game;

public class TableView extends BaseView {

    private Game game;

    public TableView(Game game) {
        this.game = game;
    }

    public void show() {
        io.writeln("===========================");
        new DeckView(game.getDeck()).show();
        new WasteView(game.getWaste(), Game.getGameMode()).show();
        for (CardSuit cardSuit : CardSuit.values()) {
            new Foundation(game.getFoundation(cardSuit), cardSuit).show();
        }
        for (int i = 0; i < Game.getNumTableauStacks(); i++) {
            new TableauStackView(game.getTableauStack(i), i).show();
        }
    }
}
