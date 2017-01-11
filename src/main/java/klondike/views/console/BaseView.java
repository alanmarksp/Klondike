package klondike.views.console;

import klondike.utils.IO;

public abstract class BaseView {

    protected IO io;

    protected BaseView() {
        io = new IO();
    }
}
