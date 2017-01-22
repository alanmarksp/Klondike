package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.models.Game;
import klondike.views.console.ErrorView;

public class MoveFromFoundationToTableauStackController extends MoveWithTableauStackAsDestination implements
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
    public Error validateDestination(Card card) {
        return super.validateDestination(card, tableauStackIndex);
    }

    @Override
    protected boolean isOriginEmpty() {
        return isFoundationEmpty(cardSuit);
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
    public Card getOriginCard() {
        return peekFoundation(cardSuit);
    }

    @Override
    public Card getDestinationCard() {
        return peeKTableauStack(tableauStackIndex);
    }

    @Override
    public CardSuit getCardSuit() {
        return cardSuit;
    }

}
