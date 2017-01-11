package klondike.views.console.models;

import klondike.models.CardSuit;
import klondike.models.Game;
import klondike.views.console.BaseView;

public class GameView extends BaseView {

    private Game game;

    public GameView(Game game) {
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
