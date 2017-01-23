package klondike.controllers;

import klondike.controllers.visitors.ActionControllerVisitor;

public interface ActionController extends PresenterController {

    void accept(ActionControllerVisitor actionControllerVisitor);
}
