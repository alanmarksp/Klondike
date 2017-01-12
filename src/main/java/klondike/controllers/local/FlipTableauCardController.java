package klondike.controllers.local;

import klondike.controllers.Error;
import klondike.controllers.visitors.ActionControllerVisitor;
import klondike.models.Game;

public class FlipTableauCardController extends BaseController implements
        klondike.controllers.FlipTableauCardController {

    public FlipTableauCardController(Game game) {
        super(game);
    }

    @Override
    public void accept(ActionControllerVisitor actionControllerVisitor) {
        actionControllerVisitor.visit(this);
    }

    @Override
    public Error validateFlip(int tableauStackIndex) {
        if (getTableauStack(tableauStackIndex).peek().isFaceUp()) {
            return Error.ALREADY_FACE_UP;
        }
        return null;
    }

    @Override
    public void flip(int tableauStackIndex) {
        getTableauStack(tableauStackIndex).peek().flipUp();
    }

    @Override
    public int getNumTableauStacks() {
        return Game.getNumTableauStacks();
    }
}
