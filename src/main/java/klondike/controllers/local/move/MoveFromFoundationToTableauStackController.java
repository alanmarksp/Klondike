package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.models.Game;
import klondike.utils.ClosedInterval;
import klondike.views.console.ErrorView;

public class MoveFromFoundationToTableauStackController extends MoveWithTableauStackAsDestinationController implements
        klondike.controllers.move.MoveFromFoundationToTableauStackController {

    private CardSuit cardSuit;

    private int tableauStackIndex;

    public MoveFromFoundationToTableauStackController(Game game) {
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
        assert cardSuit != null;
        return popFromFoundation(cardSuit);
    }

    @Override
    public void push(Card card) {
        assert card != null;
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        pushToTableauStack(card, tableauStackIndex);
    }

    @Override
    public void pushBack(Card card) {
        assert card != null;
        assert cardSuit != null;
        pushToFoundation(card, cardSuit);
    }

    @Override
    public Error validateDestination(Card card) {
        assert card != null;
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return super.validateDestination(card, tableauStackIndex);
    }

    @Override
    protected boolean isOriginEmpty() {
        assert cardSuit != null;
        return isFoundationEmpty(cardSuit);
    }

    @Override
    public void setOrigin(CardSuit cardSuit) {
        assert cardSuit != null;
        this.cardSuit = cardSuit;
    }

    @Override
    public void setDestination(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        this.tableauStackIndex = tableauStackIndex;
    }

    @Override
    public Card getOriginCard() {
        assert cardSuit != null;
        return peekFoundation(cardSuit);
    }

    @Override
    public Card getDestinationCard() {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return peeKTableauStack(tableauStackIndex);
    }

    @Override
    public CardSuit getCardSuit() {
        assert cardSuit != null;
        return cardSuit;
    }

}
