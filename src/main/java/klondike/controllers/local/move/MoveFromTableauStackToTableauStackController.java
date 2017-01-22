package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.Game;
import klondike.views.console.ErrorView;

import java.util.Stack;

public class MoveFromTableauStackToTableauStackController extends MoveWithTableauStackAsDestinationController implements
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
    public Card pop() {
        return popFromTableauStack(originTableauStackIndex);
    }

    @Override
    public void push(Card card) {
        pushToTableauStack(card, destinaitonTableauStackIndex);
    }

    @Override
    public Error validateOrigin() {
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
        return isTableauStackEmpty(originTableauStackIndex);
    }

    @Override
    public Error validateDestination(Card card) {
        if (!card.isFaceUp()) {
            return Error.ORIGIN_CARD_FACE_DOWN;
        }
        return super.validateDestination(card, destinaitonTableauStackIndex);
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
        return peeKTableauStack(destinaitonTableauStackIndex);
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
