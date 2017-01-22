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
        pushToFoundation(card, cardSuit);
    }

    @Override
    protected boolean isOriginEmpty() {
        return isWasteEmpty();
    }

    @Override
    public Error validateDestination(Card card) {
        return super.validateDestination(card, cardSuit);
    }

    @Override
    public void setDestination(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
        destination = getFoundation(cardSuit);
    }

    @Override
    public Card getOriginCard() {
        return peekWaste();
    }

    @Override
    public Card getDestinationCard() {
        return peekFoundation(cardSuit);
    }

    @Override
    public void pushBack(Card card) {
        pushToWaste(card);
    }
}
