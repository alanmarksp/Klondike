package klondike;

import klondike.controllers.Controller;

public class Klondike {

    private Logic logic;

    private View view;

    private Klondike(Logic logic, View view) {
        this.logic = logic;
        this.view = view;
    }

    private void play() {
        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                view.interact(controller);
            }
        } while (controller != null);
    }

    public static void main(String[] args) {
        new Klondike(new klondike.controllers.local.Logic(), new klondike.views.console.View()).play();
    }

}
