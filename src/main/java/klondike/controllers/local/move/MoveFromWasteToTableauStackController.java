package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.CardValue;
import klondike.models.Game;
import klondike.views.console.ErrorView;

public class MoveFromWasteToTableauStackController extends MoveWithCardValidationController implements
        klondike.controllers.move.MoveFromWasteToTableauStackController {

    private int tableauStackIndex;

    public MoveFromWasteToTableauStackController(Game game) {
        super(game);
        origin = game.getWaste();
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
        return popFromWaste();
    }

    @Override
    public void push(Card card) {
        pushToTableauStack(card, tableauStackIndex);
    }

    @Override
    public Error validateOrigin() {
        if (isWasteEmpty()) {
            return Error.EMPTY_STACK;
        }
        return null;
    }

    @Override
    public Error validateDestination(Card card) {
        if (!isTableauStackEmpty(tableauStackIndex) && !isCardOnTabelauStackFacedUp(tableauStackIndex)) {
            return Error.DESTINATION_CARD_FACE_DOWN;
        }
        if (isTableauStackEmpty(tableauStackIndex) && card.getValue() != CardValue.KING ||
                !isTableauStackEmpty(tableauStackIndex) &&
                        card.getSuit().isSameColor(getCardSuitFromTableauStack(tableauStackIndex)) ||
                !isTableauStackEmpty(tableauStackIndex) &&
                        card.getValue().ordinal() + 1 != getCardValueFromTableauStack(tableauStackIndex).ordinal()) {
            return Error.INVALID_MOVE;
        }
        return null;
    }

    @Override
    public void setDestination(int tableauStackIndex) {
        this.tableauStackIndex = tableauStackIndex;
        destination = getTableauStack(tableauStackIndex);
    }

    @Override
    public void pushBack(Card card) {
        pushToWaste(card);
    }
}
