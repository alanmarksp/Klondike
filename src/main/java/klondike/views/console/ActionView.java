package klondike.views.console;

import klondike.controllers.*;
import klondike.controllers.Error;
import klondike.controllers.move.MoveController;
import klondike.controllers.visitors.ActionControllerVisitor;
import klondike.utils.LimitedIntDialog;
import klondike.views.console.models.GameView;

public class ActionView extends BaseView implements ActionControllerVisitor {

    private MoveView moveView;

    public ActionView() {
        moveView = new MoveView();
    }

    public void interact(ActionController actionController) {
        actionController.accept(this);
    }

    @Override
    public void visit(MoveController moveController) {
        moveView.interact(moveController);
    }

    @Override
    public void visit(FlipTableauCardController flipTableauCardController) {
        int numTableauStacks = flipTableauCardController.getNumTableauStacks();
        int tableauStackIndex = new LimitedIntDialog("En que escalera?", numTableauStacks).read() - 1;
        Error error = flipTableauCardController.validateFlip(tableauStackIndex);
        if (error == null) {
            flipTableauCardController.flip(tableauStackIndex);
            new GameView(flipTableauCardController.getGame()).show();
            new MenuView().show();
        } else {
            io.writeln(error.toString());
        }
    }

    @Override
    public void visit(ExitGameController exitGameController) {
        exitGameController.exit();
    }
}