package klondike.controllers;

import klondike.controllers.visitors.ActionControllerVisitor;

public interface ActionController extends Controller {

    void accept(ActionControllerVisitor actionControllerVisitor);
}
