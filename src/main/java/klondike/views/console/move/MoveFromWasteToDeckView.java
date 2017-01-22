package klondike.views.console.move;

import klondike.controllers.Error;
import klondike.controllers.move.MoveFromWasteToDeckController;
import klondike.views.console.ErrorView;
import klondike.views.console.MenuView;
import klondike.views.console.models.GameView;

public class MoveFromWasteToDeckView extends MoveWithOriginValidation {

    public void interact(MoveFromWasteToDeckController moveFromWasteToDeckController) {
        if (validateOrigin(moveFromWasteToDeckController)) {
            Error error = moveFromWasteToDeckController.validateDestination();
            if (error != null) {
                new ErrorView(error).interact(moveFromWasteToDeckController);
                return;
            }
            while (moveFromWasteToDeckController.getOriginSize() > 0) {
                moveFromWasteToDeckController.push(moveFromWasteToDeckController.pop().flipDown());
            }
            new GameView(moveFromWasteToDeckController).show();
            new MenuView().show();
        }
    }
}
