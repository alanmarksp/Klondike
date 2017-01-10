package klondike.views.console;

import klondike.utils.LimitedIntDialog;

class MenuView extends BaseView {

    public static final int NUM_OPTIONS = 9;

    public void show() {
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
    }

    int getOption() {
        return new LimitedIntDialog("Opción?", NUM_OPTIONS).read() - 1;
    }

}
