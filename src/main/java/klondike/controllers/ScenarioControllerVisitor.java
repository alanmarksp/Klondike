package klondike.controllers;

public interface ScenarioControllerVisitor {

    void visit(PlayController playController);

    void visit(ContinueController continueController);
}
