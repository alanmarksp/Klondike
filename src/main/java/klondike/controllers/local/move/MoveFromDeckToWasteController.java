package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.models.Game;

public class MoveFromDeckToWasteController extends MoveController {

    public MoveFromDeckToWasteController(Game game) {
        super(game);
        origin = game.getDeck();
        destination = game.getWaste();
    }

    @Override
    public void move() {
        for (int i = 0; i < getGameMode() && !origin.isEmpty(); i++) {
            destination.push(origin.pop().flipUp());
        }
    }

    @Override
    public Error validateMove() {
        if (origin.isEmpty()) {
            return Error.EMPTY_STACK;
        }
        return null;
    }
}