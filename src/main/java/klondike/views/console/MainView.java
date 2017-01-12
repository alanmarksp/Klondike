package klondike.views.console;

import klondike.controllers.ContinueController;
import klondike.controllers.GameController;
import klondike.controllers.ScenarioController;
import klondike.controllers.local.StartController;

public class MainView implements klondike.View {

    private final StartView startView;

    private final GameView gameView;

    private final ContinueView continueView;

    public MainView() {
        startView = new StartView();
        gameView = new GameView();
        continueView = new ContinueView();
    }

    @Override
    public void interact(ScenarioController controller) {
        assert controller != null;
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        assert startController != null;
        startView.interact(startController);
    }

    @Override
    public void visit(GameController gameController) {
        assert gameController != null;
        gameView.interact(gameController);
    }

    @Override
    public void visit(ContinueController continueController) {
        assert continueController != null;
        continueView.interact(continueController);
    }
}
