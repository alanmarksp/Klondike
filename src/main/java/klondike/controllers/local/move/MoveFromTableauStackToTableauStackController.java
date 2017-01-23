package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.Game;
import klondike.utils.ClosedInterval;
import klondike.views.console.ErrorView;

import java.util.Stack;

public class MoveFromTableauStackToTableauStackController extends MoveWithTableauStackAsDestinationController implements
        klondike.controllers.move.MoveFromTableauStackToTableauStackController {

    private int numCardsToMove;

    private int originTableauStackIndex;

    private int destinationTableauStackIndex;

    public MoveFromTableauStackToTableauStackController(Game game) {
        super(game);
    }

    @Override
    public void accept(MoveControllerVisitor moveControllerVisitor) {
        assert moveControllerVisitor != null;
        moveControllerVisitor.visit(this);
    }

    @Override
    public void accept(ErrorView errorView) {
        assert errorView != null;
        errorView.visit(this);
    }

    @Override
    public Card pop() {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(originTableauStackIndex);
        return popFromTableauStack(originTableauStackIndex);
    }

    @Override
    public void push(Card card) {
        assert card != null;
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(destinationTableauStackIndex);
        pushToTableauStack(card, destinationTableauStackIndex);
    }

    @Override
    public Error validateOrigin() {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(originTableauStackIndex);
        Error error = super.validateOrigin();
        if (error != null) {
            return error;
        }
        if (getTableauStackSize(originTableauStackIndex) < numCardsToMove) {
            return Error.INVALID_NUM_CARDS_TO_MOVE;
        }
        return null;
    }

    @Override
    protected boolean isOriginEmpty() {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(originTableauStackIndex);
        return isTableauStackEmpty(originTableauStackIndex);
    }

    @Override
    public Error validateDestination(Card card) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(destinationTableauStackIndex);
        assert card != null;
        if (!card.isFaceUp()) {
            return Error.ORIGIN_CARD_FACE_DOWN;
        }
        return super.validateDestination(card, destinationTableauStackIndex);
    }

    @Override
    public void setOrigin(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        originTableauStackIndex = tableauStackIndex;
    }

    @Override
    public void setDestination(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        destinationTableauStackIndex = tableauStackIndex;
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
    public Card getOriginCard() {
        Stack<Card> cards = new Stack<>();
        for (int i = 0; i < numCardsToMove; i++) {
            cards.push(pop());
        }
        Card card = cards.peek();
        while (!cards.isEmpty()) {
            pushBack(cards.pop());
        }
        return card;
    }

    @Override
    public Card getDestinationCard() {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(destinationTableauStackIndex);
        return peeKTableauStack(destinationTableauStackIndex);
    }

    @Override
    public int getTableauStackIndex() {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(originTableauStackIndex);
        return originTableauStackIndex;
    }

    @Override
    public void pushBack(Card card) {
        assert card != null;
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(originTableauStackIndex);
        pushToTableauStack(card, originTableauStackIndex);
    }
}
