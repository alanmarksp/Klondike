package klondike.controllers.local;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.models.CardValue;
import klondike.models.Game;

public class MoveFromTableauStackToFoundationController extends MoveController implements
        klondike.controllers.MoveFromTableauStackToFoundationController {

    public MoveFromTableauStackToFoundationController(Game game) {
        super(game);
    }

    @Override
    public void accept(MoveControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }

    @Override
    public Error validateMove() {
        setDestination(getOriginCard().getSuit());
        if (origin.isEmpty()) {
            return Error.EMPTY_STACK;
        }
        if (destination.isEmpty() && getOriginCard().getValue() != CardValue.ACE ||
                !destination.isEmpty() && getOriginCard().getSuit() != getDestinationCard().getSuit()) {
            return Error.INVALID_MOVE;
        }
        return null;
    }

    @Override
    public void setOrigin(int tableauStackIndex) {
        origin = getGame().getTableauStack(tableauStackIndex);
    }

    @Override
    public void setDestination(CardSuit cardSuit) {
        destination = getGame().getFoundation(cardSuit);
    }

    @Override
    public Card getOriginCard() {
        return origin.peek();
    }

    @Override
    public Card getDestinationCard() {
        return destination.peek();
    }
}
