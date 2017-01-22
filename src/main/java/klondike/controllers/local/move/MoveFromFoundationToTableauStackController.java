package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.models.CardValue;
import klondike.models.Game;
import klondike.views.console.ErrorView;

public class MoveFromFoundationToTableauStackController extends MoveWithCardValidationController implements
        klondike.controllers.move.MoveFromFoundationToTableauStackController {

    private CardSuit cardSuit;

    private int tableauStackIndex;

    public MoveFromFoundationToTableauStackController(Game game) {
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
        if (!destination.isEmpty() && !getDestinationCard().isFaceUp()) {
            return Error.DESTINATION_CARD_FACE_DOWN;
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
        return popFromFoundation(cardSuit);
    }

    @Override
    public void push(Card card) {
        pushToTableauStack(card, tableauStackIndex);
    }

    @Override
    public void pushBack(Card card) {
        pushToFoundation(card, cardSuit);
    }

    @Override
    public Error validateOrigin() {
        if (isFoundationEmpty(cardSuit)) {
            return Error.EMPTY_STACK;
        }
        return null;
    }

    @Override
    public Error validateDestination(Card card) {
        if (!isTableauStackEmpty(tableauStackIndex) && !isCardOnTabelauStackFacedUp(tableauStackIndex)) {
            return Error.DESTINATION_CARD_FACE_DOWN;
        }
        if (isTableauStackEmpty(tableauStackIndex) && card.getValue() != CardValue.KING || !destination.isEmpty() &&
                card.getSuit().isSameColor(getCardSuitFromTableauStack(tableauStackIndex)) || !destination.isEmpty() &&
                card.getValue().ordinal() + 1 != getCardValueFromTableauStack(tableauStackIndex).ordinal()) {
            return Error.INVALID_MOVE;
        }
        return null;
    }

    @Override
    public void setOrigin(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
        origin = getFoundation(cardSuit);
    }

    @Override
    public void setDestination(int tableauStackIndex) {
        this.tableauStackIndex = tableauStackIndex;
        destination = getTableauStack(tableauStackIndex);
    }

    @Override
    public CardSuit getCardSuit() {
        return cardSuit;
    }

}
