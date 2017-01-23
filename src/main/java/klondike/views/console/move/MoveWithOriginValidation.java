package klondike.views.console.move;

import klondike.controllers.Error;
import klondike.controllers.move.MoveController;
import klondike.views.console.ErrorView;

public abstract class MoveWithOriginValidation {

    protected boolean validateOrigin(MoveController moveController) {
        assert moveController != null;
        Error error = moveController.validateOrigin();
        if (error != null) {
            new ErrorView(error).interact(moveController);
            return false;
        }
        return true;
    }
}
