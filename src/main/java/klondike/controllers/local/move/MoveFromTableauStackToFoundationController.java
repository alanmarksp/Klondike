package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.models.CardValue;
import klondike.models.Game;
import klondike.views.console.ErrorView;

public class MoveFromTableauStackToFoundationController extends MoveWithCardValidationController implements
        klondike.controllers.move.MoveFromTableauStackToFoundationController {

    private int tableauStackIndex;

    private CardSuit cardSuit;

    public MoveFromTableauStackToFoundationController(Game game) {
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
    public Error validateMove() {
        if (origin.isEmpty()) {
            return Error.EMPTY_STACK;
        }
        setDestination(getOriginCard().getSuit());
        if (destination.isEmpty() && getOriginCard().getValue() != CardValue.ACE ||
                !destination.isEmpty() && getOriginCard().getSuit() != getDestinationCard().getSuit() ||
                !destination.isEmpty() && getDestinationCard().getValue().ordinal() != getOriginCard().getValue().ordinal() + 1) {
            return Error.INVALID_MOVE;
        }
        return null;
    }

    @Override
    public Card pop() {
        return popFromTableauStack(tableauStackIndex);
    }

    @Override
    public void push(Card card) {
        pushToFoundation(card, cardSuit);
    }

    @Override
    public Error validateOrigin() {
        if (isTableauStackEmpty(tableauStackIndex)) {
            return Error.EMPTY_STACK;
        }
        return null;
    }

    @Override
    public Error validateDestination(Card card) {
        if (isFoundationEmpty(cardSuit) && card.getValue() != CardValue.ACE || !isFoundationEmpty(cardSuit) &&
                card.getValue().ordinal() + 1 != getCardValueFromFoundation(cardSuit).ordinal()) {
            return Error.INVALID_MOVE;
        }
        return null;
    }

    @Override
    public void setOrigin(int tableauStackIndex) {
        this.tableauStackIndex = tableauStackIndex;
        origin = getTableauStack(tableauStackIndex);
    }

    @Override
    public void setDestination(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
        destination = getFoundation(cardSuit);
    }

    @Override
    public int getTableauStackIndex() {
        return tableauStackIndex;
    }

    @Override
    public void pushBack(Card card) {
        pushToTableauStack(card, tableauStackIndex);
    }
}
