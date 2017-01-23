package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.models.Game;
import klondike.utils.ClosedInterval;
import klondike.views.console.ErrorView;

public class MoveFromTableauStackToFoundationController extends MoveWithFoundationAsDestinationController implements
        klondike.controllers.move.MoveFromTableauStackToFoundationController {

    private int tableauStackIndex;

    private CardSuit cardSuit;

    public MoveFromTableauStackToFoundationController(Game game) {
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
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return popFromTableauStack(tableauStackIndex);
    }

    @Override
    public void push(Card card) {
        assert card != null;
        assert cardSuit != null;
        pushToFoundation(card, cardSuit);
    }

    @Override
    protected boolean isOriginEmpty() {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return isTableauStackEmpty(tableauStackIndex);
    }

    @Override
    public Error validateDestination(Card card) {
        assert card != null;
        assert cardSuit != null;
        return super.validateDestination(card, cardSuit);
    }

    @Override
    public void setOrigin(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        this.tableauStackIndex = tableauStackIndex;
    }

    @Override
    public void setDestination(CardSuit cardSuit) {
        assert cardSuit != null;
        this.cardSuit = cardSuit;
    }

    @Override
    public Card getOriginCard() {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return peeKTableauStack(tableauStackIndex);
    }

    @Override
    public Card getDestinationCard() {
        assert cardSuit != null;
        return peekFoundation(cardSuit);
    }

    @Override
    public int getTableauStackIndex() {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return tableauStackIndex;
    }

    @Override
    public void pushBack(Card card) {
        assert card != null;
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        pushToTableauStack(card, tableauStackIndex);
    }
}
