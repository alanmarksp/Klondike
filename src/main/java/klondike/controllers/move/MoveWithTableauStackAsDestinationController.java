package klondike.controllers.move;

public interface MoveWithTableauStackAsDestinationController extends MoveWithDestinationValidationController {

    void setDestination(int tableauStackIndex);
}
