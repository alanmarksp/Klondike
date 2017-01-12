package klondike.controllers;

import klondike.controllers.visitors.ActionControllerVisitor;

public interface ActionController extends BaseController {

    void accept(ActionControllerVisitor actionControllerVisitor);
}
