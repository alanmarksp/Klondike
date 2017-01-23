package klondike.controllers.move;

import klondike.controllers.Error;
import klondike.models.Card;
import klondike.models.CardSuit;

import java.util.List;

public interface MoveFromFoundationToTableauStackController extends MoveWithTableauStackAsDestinationController {

    void pushBack(Card card);

    Error validateOrigin();

    void setOrigin(CardSuit cardSuit);

    Card getOriginCard();

    Card getDestinationCard();

    CardSuit getCardSuit();

    List<CardSuit> getCardSuiteValues();
}
