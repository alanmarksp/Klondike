package klondike.controllers.local;

import klondike.controllers.Error;
import klondike.controllers.visitors.ActionControllerVisitor;
import klondike.models.Game;
import klondike.utils.ClosedInterval;

public class FlipTableauCardController extends BaseController implements
        klondike.controllers.FlipTableauCardController {

    public FlipTableauCardController(Game game) {
        super(game);
    }

    @Override
    public void accept(ActionControllerVisitor actionControllerVisitor) {
        assert actionControllerVisitor != null;
        actionControllerVisitor.visit(this);
    }

    @Override
    public Error validateFlip(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        if (isCardOnTabelauStackFacedUp(tableauStackIndex)) {
            return Error.ALREADY_FACE_UP;
        }
        return null;
    }

    @Override
    public void flip(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        flipUp(tableauStackIndex);
    }

    @Override
    public int getNumTableauStacks() {
        return Game.getNumTableauStacks();
    }
}
