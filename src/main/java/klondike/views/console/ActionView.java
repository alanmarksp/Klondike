package klondike.views.console;

import klondike.controllers.ActionController;
import klondike.controllers.Error;
import klondike.controllers.ExitGameController;
import klondike.controllers.FlipTableauCardController;
import klondike.controllers.move.MoveController;
import klondike.controllers.visitors.ActionControllerVisitor;
import klondike.utils.LimitedIntDialog;
import klondike.views.console.models.GameView;
import klondike.views.console.move.MoveView;

public class ActionView implements ActionControllerVisitor {

    private MoveView moveView;

    public ActionView() {
        moveView = new MoveView();
    }

    public void interact(ActionController actionController) {
        assert actionController != null;
        actionController.accept(this);
    }

    @Override
    public void visit(MoveController moveController) {
        assert moveController != null;
        moveView.interact(moveController);
    }

    @Override
    public void visit(FlipTableauCardController flipTableauCardController) {
        assert flipTableauCardController != null;
        int numTableauStacks = flipTableauCardController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("En que escalera?", numTableauStacks).read() - 1;
        Error error = flipTableauCardController.validateFlip(tableauStackIndex);
        if (error == null) {
            flipTableauCardController.flip(tableauStackIndex);
            new GameView(flipTableauCardController).show();
            new MenuView().show();
        } else {
            new ErrorView(error).interact(flipTableauCardController);
        }
    }

    @Override
    public void visit(ExitGameController exitGameController) {
        assert exitGameController != null;
        exitGameController.exit();
    }
}
