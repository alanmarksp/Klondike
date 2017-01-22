package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.models.Game;
import klondike.views.console.ErrorView;

public class MoveFromTableauStackToFoundationController extends MoveWithFoundationAsDestination implements
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
    public Card pop() {
        return popFromTableauStack(tableauStackIndex);
    }

    @Override
    public void push(Card card) {
        pushToFoundation(card, cardSuit);
    }

    @Override
    protected boolean isOriginEmpty() {
        return isTableauStackEmpty(tableauStackIndex);
    }

    @Override
    public Error validateDestination(Card card) {
        return super.validateDestination(card, cardSuit);
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
    public Card getOriginCard() {
        return peeKTableauStack(tableauStackIndex);
    }

    @Override
    public Card getDestinationCard() {
        return peekFoundation(cardSuit);
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
