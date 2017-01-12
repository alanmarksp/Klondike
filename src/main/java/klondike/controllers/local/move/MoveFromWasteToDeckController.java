package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Game;

public class MoveFromWasteToDeckController extends MoveController implements
        klondike.controllers.move.MoveFromWasteToDeckController {

    public MoveFromWasteToDeckController(Game game) {
        super(game);
        origin = game.getWaste();
        destination = game.getDeck();
    }

    @Override
    public void accept(MoveControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }

    @Override
    public void move() {
        while (!origin.isEmpty()) {
            destination.push(origin.pop().flipDown());
        }
    }

    @Override
    public Error validateMove() {
        if (!destination.isEmpty()) {
            return Error.NON_EMPTY_DECK;
        }
        return null;
    }
}
