package klondike.views.console;

import klondike.controllers.ContinueController;
import klondike.utils.YesNoDialog;

class ContinueView {

    void interact(ContinueController continueController) {
        continueController.resume(new YesNoDialog("Desea continuar")
                .read());
    }
}
