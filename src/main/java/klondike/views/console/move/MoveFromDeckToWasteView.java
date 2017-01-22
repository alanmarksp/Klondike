package klondike.views.console.move;

import klondike.controllers.Error;
import klondike.controllers.move.MoveFromDeckToWasteController;
import klondike.views.console.ErrorView;
import klondike.views.console.MenuView;
import klondike.views.console.models.GameView;

public class MoveFromDeckToWasteView {

    public void interact(MoveFromDeckToWasteController moveFromDeckToWasteController) {
        Error error = moveFromDeckToWasteController.validateOrigin();
        if (error != null) {
            new ErrorView(error).interact(moveFromDeckToWasteController);
            return;
        }
        for (int i = 0; i < moveFromDeckToWasteController.getGameMode() && moveFromDeckToWasteController.getOriginSize() > 0; i++) {
            moveFromDeckToWasteController.push(moveFromDeckToWasteController.pop().flipUp());
        }
        new GameView(moveFromDeckToWasteController).show();
        new MenuView().show();
    }

}
