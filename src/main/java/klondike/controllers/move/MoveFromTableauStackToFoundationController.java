package klondike.controllers.move;

import klondike.controllers.Error;
import klondike.models.Card;

public interface MoveFromTableauStackToFoundationController extends MoveWithFoundationAsDestinationController {

    Error validateOrigin();

    void setOrigin(int tableauStackIndex);

    Card getOriginCard();

    Card getDestinationCard();

    int getTableauStackIndex();

    void pushBack(Card card);
}
