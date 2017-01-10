package klondike.views.console;

import klondike.utils.IO;

abstract class BaseView {

    IO io;

    BaseView() {
        io = new IO();
    }
}
