package klondike.controllers.local.move;

import klondike.controllers.Error;
import klondike.controllers.visitors.MoveControllerVisitor;
import klondike.models.Card;
import klondike.models.CardSuit;
import klondike.models.Game;
import klondike.views.console.ErrorView;

public class MoveFromWasteToFoundationController extends MoveWithFoundationAsDestinationController implements
        klondike.controllers.move.MoveFromWasteToFoundationController {

    private CardSuit cardSuit;

    public MoveFromWasteToFoundationController(Game game) {
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
        assert cardSuit != null;
        pushToFoundation(card, cardSuit);
    }

    @Override
    protected boolean isOriginEmpty() {
        return isWasteEmpty();
    }

    @Override
    public Error validateDestination(Card card) {
        assert card != null;
        assert cardSuit != null;
        return super.validateDestination(card, cardSuit);
    }

    @Override
    public void setDestination(CardSuit cardSuit) {
        assert cardSuit != null;
        this.cardSuit = cardSuit;
    }

    @Override
    public Card getOriginCard() {
        return peekWaste();
    }

    @Override
    public Card getDestinationCard() {
        assert cardSuit != null;
        return peekFoundation(cardSuit);
    }

    @Override
    public void pushBack(Card card) {
        assert card != null;
        pushToWaste(card);
    }
}
