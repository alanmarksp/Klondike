package klondike.views.console;

import klondike.utils.IO;

public abstract class BaseView {

    protected IO io;

    public BaseView() {
        io = new IO();
    }
}
