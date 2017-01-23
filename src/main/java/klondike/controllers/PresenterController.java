package klondike.controllers;

import klondike.models.Card;
import klondike.models.CardSuit;

import java.util.Stack;

public interface PresenterController {

    Stack<Card> getDeck();

    Stack<Card> getWaste();

    Stack<Card> getFoundation(CardSuit cardSuit);

    Stack<Card> getTableauStack(int tableauStackIndex);

    int getGameMode();

    int getNumTableauStacks();
}
