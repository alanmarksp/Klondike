package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.CardValue;
import klondike.models.Game;
import klondike.views.console.ErrorView;

import java.util.Stack;

public class MoveFromTableauStackToTableauStackController extends MoveWithCardValidationController implements
        klondike.controllers.move.MoveFromTableauStackToTableauStackController {

    private int numCardsToMove;

    private int originTableauStackIndex;

    private int destinaitonTableauStackIndex;

    public MoveFromTableauStackToTableauStackController(Game game) {
        super(game);
    }

    @Override
    public void accept(MoveControllerVisitor moveControllerVisitor) {
        moveControllerVisitor.visit(this);
    }

    @Override
    public void accept(ErrorView errorView) {
        errorView.visit(this);
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
    public Card pop() {
        return popFromTableauStack(originTableauStackIndex);
    }

    @Override
    public void push(Card card) {
        pushToTableauStack(card, destinaitonTableauStackIndex);
    }

    @Override
    public Error validateOrigin() {
        if (isTableauStackEmpty(originTableauStackIndex)) {
            return Error.EMPTY_STACK;
        }
        if (getTableauStackSize(originTableauStackIndex) < numCardsToMove) {
            return Error.INVALID_NUM_CARDS_TO_MOVE;
        }
        return null;
    }

    @Override
    public Error validateDestination(Card card) {
        if (!card.isFaceUp()) {
            return Error.ORIGIN_CARD_FACE_DOWN;
        }
        if (!isTableauStackEmpty(destinaitonTableauStackIndex) &&
                !isCardOnTabelauStackFacedUp(destinaitonTableauStackIndex)) {
            return Error.DESTINATION_CARD_FACE_DOWN;
        }
        if (isTableauStackEmpty(destinaitonTableauStackIndex) && card.getValue() != CardValue.KING ||
                !isTableauStackEmpty(destinaitonTableauStackIndex) &&
                        card.getSuit().isSameColor(getCardSuitFromTableauStack(destinaitonTableauStackIndex)) ||
                !isTableauStackEmpty(destinaitonTableauStackIndex) &&
                        card.getValue().ordinal() + 1 != getCardValueFromTableauStack(destinaitonTableauStackIndex).ordinal()) {
            return Error.INVALID_MOVE;
        }
        return null;
    }

    @Override
    public void setOrigin(int tableauStackIndex) {
        originTableauStackIndex = tableauStackIndex;
        origin = getTableauStack(tableauStackIndex);
    }

    @Override
    public void setDestination(int tableauStackIndex) {
        destinaitonTableauStackIndex = tableauStackIndex;
        destination = getTableauStack(tableauStackIndex);
    }

    @Override
    public int getNumCardsToMove() {
        return numCardsToMove;
    }

    @Override
    public void setNumCardsToMove(int numCardsToMove) {
        this.numCardsToMove = numCardsToMove;
    }

    @Override
    public int getTableauStackIndex() {
        return originTableauStackIndex;
    }

    @Override
    public void pushBack(Card card) {
        pushToTableauStack(card, originTableauStackIndex);
    }
}
