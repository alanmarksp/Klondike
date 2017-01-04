package klondike.views.console;

import klondike.controllers.ContinueController;
import klondike.controllers.PlayController;
import klondike.controllers.ScenarioController;
import klondike.utils.IO;
import klondike.utils.LimitedIntDialog;

public class View implements klondike.View {

    private IO io;

    public View() {
        io = new IO();
    }

    @Override
    public void interact(ScenarioController controller) {
        assert controller != null;
        controller.accept(this);
    }

    @Override
    public void visit(PlayController playController) {
        assert playController != null;
        io.writeln("===========================");
        // TODO Print Table
        io.writeln("---------------------------");
        io.writeln("1. Mover de baraja a descarte");
        io.writeln("2. Mover de descarte a baraja");
        io.writeln("3. Mover de descarte a palo");
        io.writeln("4. Mover de descarte a escalera");
        io.writeln("5. Mover de escalera a palo");
        io.writeln("6. Mover de escalera a escalera");
        io.writeln("7. Mover de palo a escalera");
        io.writeln("8. Voltear en escalera");
        io.writeln("9. Salir");

        int option = new LimitedIntDialog("Opción?", 9).read() - 1;
        playController.getActionController(option);
    }

    @Override
    public void visit(ContinueController continueController) {

    }
}
