package klondike.controllers;

public interface FlipTableauCardController extends ActionController {

    Error validateFlip(int tableauStackIndex);

    void flip(int tableauStackIndex);

    int getNumTableauStacks();

}
