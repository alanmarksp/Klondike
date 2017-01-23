package klondike.controllers;

import klondike.models.GameMode;

public interface StartController extends ScenarioController {

    void start(GameMode gameMode);
}
