package klondike.controllers;

import klondike.models.Game;

public interface Controller {

    Game getGame();

    int getGameMode();
}
