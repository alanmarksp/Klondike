package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.CardValue;
import klondike.models.Game;

import java.util.Stack;

public class MoveFromTableauStackToTableauStackController extends MoveController implements
        klondike.controllers.move.MoveFromTableauStackToTableauStackController {

    private int numCardsToMove;

    public MoveFromTableauStackToTableauStackController(Game game) {
        super(game);
    }

    @Override
    public void accept(MoveControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }

    @Override
    public void move() {
        Stack<Card> cards = new Stack<>();
        for (int i = 0; i < numCardsToMove; i++) {
            cards.push(origin.pop());
        }
        while (!cards.isEmpty()) {
            destination.push(cards.pop());
        }
    }

    @Override
    public Error validateMove() {
        if (origin.isEmpty()) {
            return Error.EMPTY_STACK;
        }
        if (!destination.isEmpty() && !getDestinationCard().isFaceUp()) {
            return Error.DESTINATION_CARD_FACE_DOWN;
        }
        if (origin.size() < numCardsToMove) {
            return Error.INVALID_NUM_CARDS_TO_MOVE;
        }
        if (!getOriginCard().isFaceUp()) {
            return Error.ORIGIN_CARD_FACE_DOWN;
        }
        if (destination.isEmpty() && getOriginCard().getValue() != CardValue.KING ||
                !destination.isEmpty() && getOriginCard().getSuit().isSameColor(getDestinationCard().getSuit()) ||
                !destination.isEmpty() && getDestinationCard().getValue().ordinal() != getOriginCard().getValue().ordinal() + 1) {
            return Error.INVALID_MOVE;
        }
        return null;
    }

    @Override
    public void setOrigin(int tableauStackIndex) {
        origin = getGame().getTableauStack(tableauStackIndex);
    }

    @Override
    public void setDestination(int tableauStackIndex) {
        destination = getGame().getTableauStack(tableauStackIndex);
    }

    @Override
    public void setNumCardsToMove(int numCardsToMove) {
        this.numCardsToMove = numCardsToMove;
    }

    @Override
    public Card getOriginCard() {
        return origin.get(origin.size() - numCardsToMove);
    }

    @Override
    public Card getDestinationCard() {
        return destination.peek();
    }
}
