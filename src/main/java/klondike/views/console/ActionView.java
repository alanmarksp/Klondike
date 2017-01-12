package klondike.views.console;

import klondike.controllers.ActionController;
import klondike.controllers.Error;
import klondike.controllers.ExitGameController;
import klondike.controllers.FlipTableauCardController;
import klondike.controllers.move.MoveController;
import klondike.controllers.visitors.ActionControllerVisitor;
import klondike.utils.IO;
import klondike.utils.LimitedIntDialog;
import klondike.views.console.models.GameView;

public class ActionView implements ActionControllerVisitor {

    private IO io = new IO();

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
