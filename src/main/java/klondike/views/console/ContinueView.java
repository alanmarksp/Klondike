package klondike.views.console;

import klondike.controllers.ContinueController;
import klondike.utils.YesNoDialog;

public class ContinueView {

    void interact(ContinueController continueController) {
        assert continueController != null;
        continueController.resume(new YesNoDialog("Desea continuar")
                .read());
    }
}
