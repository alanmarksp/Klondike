package klondike.controllers.move;

import klondike.controllers.Error;

public interface MoveFromDeckToWasteController extends MoveController {

    Error validateOrigin();
}
