package klondike.controllers.move;

import klondike.controllers.Error;

public interface MoveFromWasteToDeckController extends MoveController {

    Error validateOrigin();

    int getOriginSize();
}
