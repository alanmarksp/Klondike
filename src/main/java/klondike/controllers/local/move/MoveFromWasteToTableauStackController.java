package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.Game;
import klondike.utils.ClosedInterval;
import klondike.views.console.ErrorView;

public class MoveFromWasteToTableauStackController extends MoveWithTableauStackAsDestinationController implements
        klondike.controllers.move.MoveFromWasteToTableauStackController {

    private int tableauStackIndex;

    public MoveFromWasteToTableauStackController(Game game) {
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
        return popFromWaste();
    }

    @Override
    public void push(Card card) {
        assert card != null;
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        pushToTableauStack(card, tableauStackIndex);
    }

    @Override
    protected boolean isOriginEmpty() {
        return isWasteEmpty();
    }

    @Override
    public Error validateDestination(Card card) {
        assert card != null;
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return super.validateDestination(card, tableauStackIndex);
    }

    @Override
    public void setDestination(int tableauStackIndex) {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        this.tableauStackIndex = tableauStackIndex;
    }

    @Override
    public Card getOriginCard() {
        return peekWaste();
    }

    @Override
    public Card getDestinationCard() {
        assert new ClosedInterval(0, getNumTableauStacks() - 1).includes(tableauStackIndex);
        return peeKTableauStack(tableauStackIndex);
    }

    @Override
    public void pushBack(Card card) {
        assert card != null;
        pushToWaste(card);
    }
}
