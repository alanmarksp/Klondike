package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.Game;
import klondike.views.console.ErrorView;

public class MoveFromWasteToTableauStackController extends MoveWithTableauStackAsDestinationController implements
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
    public Card pop() {
        return popFromWaste();
    }

    @Override
    public void push(Card card) {
        pushToTableauStack(card, tableauStackIndex);
    }

    @Override
    protected boolean isOriginEmpty() {
        return isWasteEmpty();
    }

    @Override
    public Error validateDestination(Card card) {
        return super.validateDestination(card, tableauStackIndex);
    }

    @Override
    public void setDestination(int tableauStackIndex) {
        this.tableauStackIndex = tableauStackIndex;
        destination = getTableauStack(tableauStackIndex);
    }

    @Override
    public Card getOriginCard() {
        return peekWaste();
    }

    @Override
    public Card getDestinationCard() {
        return peeKTableauStack(tableauStackIndex);
    }

    @Override
    public void pushBack(Card card) {
        pushToWaste(card);
    }
}
