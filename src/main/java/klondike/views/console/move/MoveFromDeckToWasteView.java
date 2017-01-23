package klondike.views.console.move;

import klondike.controllers.move.MoveFromDeckToWasteController;
import klondike.views.console.MenuView;
import klondike.views.console.models.GameView;

public class MoveFromDeckToWasteView extends MoveWithOriginValidation {

    public void interact(MoveFromDeckToWasteController moveFromDeckToWasteController) {
        assert moveFromDeckToWasteController != null;
        if (validateOrigin(moveFromDeckToWasteController)) {
            for (int i = 0; i < moveFromDeckToWasteController.getGameMode() && moveFromDeckToWasteController.getOriginSize() > 0; i++) {
                moveFromDeckToWasteController.push(moveFromDeckToWasteController.pop().flipUp());
            }
            new GameView(moveFromDeckToWasteController).show();
            new MenuView().show();
        }
    }

}
