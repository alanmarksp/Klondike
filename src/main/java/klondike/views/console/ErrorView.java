package klondike.views.console;

import klondike.controllers.Error;
import klondike.controllers.FlipTableauCardController;
import klondike.controllers.move.*;
import klondike.models.Card;
import klondike.utils.IO;
import klondike.views.console.models.CardView;

public class ErrorView {

    private IO io = new IO();

    private Error error;

    public ErrorView(Error error) {
        assert error != null;
        this.error = error;
    }

    public void interact(MoveController moveController) {
        assert moveController != null;
        moveController.accept(this);
    }

    private void showError(String errorMsg) {
        assert errorMsg != null;
        io.writeln("Error!!! " + errorMsg);
    }

    private void showInvalidMoveError(Card origin, Card destination) {
        assert origin != null;
        io.write("Error!!! No se puede poner ");
        new CardView(origin).show();
        io.write(" sobre ");
        if (destination != null) {
            new CardView(destination).show();
        } else {
            io.write("vacío");
        }
        io.writeln();
    }

    public void visit(MoveFromDeckToWasteController moveFromDeckToWasteController) {
        assert error == Error.EMPTY_STACK;
        assert moveFromDeckToWasteController != null;
        showError("La baraja está vacía");
    }

    public void visit(MoveFromFoundationToTableauStackController moveFromFoundationToTableauStackController) {
        assert moveFromFoundationToTableauStackController != null;
        switch (error) {
            case EMPTY_STACK:
                showError("El Palo de " + moveFromFoundationToTableauStackController.getCardSuit() +
                        " esta vacío");
                break;
            case DESTINATION_CARD_FACE_DOWN:
                showError("No se puede mover sobre una carta cubierta");
                break;
            case INVALID_MOVE:
                showInvalidMoveError(moveFromFoundationToTableauStackController.getOriginCard(),
                        moveFromFoundationToTableauStackController.getDestinationCard());
                break;
        }
    }

    public void visit(MoveFromTableauStackToFoundationController moveFromTableauStackToFoundationController) {
        assert moveFromTableauStackToFoundationController != null;
        switch (error) {
            case EMPTY_STACK:
                showError("La escalera " + moveFromTableauStackToFoundationController.getTableauStackIndex() +
                        " esta vacío");
                break;
            case INVALID_MOVE:
                showInvalidMoveError(moveFromTableauStackToFoundationController.getOriginCard(),
                        moveFromTableauStackToFoundationController.getDestinationCard());
                break;
        }
    }

    public void visit(MoveFromTableauStackToTableauStackController moveFromTableauStackToTableauStackController) {
        assert moveFromTableauStackToTableauStackController != null;
        switch (error) {
            case EMPTY_STACK:
                showError("La escalera " + moveFromTableauStackToTableauStackController.getTableauStackIndex() +
                        " esta vacío");
                break;
            case INVALID_MOVE:
                showInvalidMoveError(moveFromTableauStackToTableauStackController.getOriginCard(),
                        moveFromTableauStackToTableauStackController.getDestinationCard());
                break;
            case DESTINATION_CARD_FACE_DOWN:
                showError("No se puede mover sobre una carta cubierta");
                break;
            case INVALID_NUM_CARDS_TO_MOVE:
                showError("No se pueden mover " + moveFromTableauStackToTableauStackController.getNumCardsToMove()
                        + " cartas desde la escalera " + moveFromTableauStackToTableauStackController.getTableauStackIndex());
                break;
            case ORIGIN_CARD_FACE_DOWN:
                showError("No se puede mover cartas descubiertas");
                break;
        }
    }

    public void visit(MoveFromWasteToDeckController moveFromWasteToDeckController) {
        assert moveFromWasteToDeckController != null;
        switch (error) {
            case EMPTY_STACK:
                showError("El descarte esta vacío");
                break;
            case NON_EMPTY_DECK:
                showError("La baraja no esta vacía");
                break;
        }
    }

    public void visit(MoveFromWasteToFoundationController moveFromWasteToFoundationController) {
        assert moveFromWasteToFoundationController != null;
        switch (error) {
            case EMPTY_STACK:
                showError("El descarte esta vacío");
                break;
            case INVALID_MOVE:
                showInvalidMoveError(moveFromWasteToFoundationController.getOriginCard(),
                        moveFromWasteToFoundationController.getDestinationCard());
                break;
        }
    }

    public void visit(MoveFromWasteToTableauStackController moveFromWasteToTableauStackController) {
        assert moveFromWasteToTableauStackController != null;
        switch (error) {
            case EMPTY_STACK:
                showError("El descarte esta vacío");
                break;
            case INVALID_MOVE:
                showInvalidMoveError(moveFromWasteToTableauStackController.getOriginCard(),
                        moveFromWasteToTableauStackController.getDestinationCard());
                break;
            case DESTINATION_CARD_FACE_DOWN:
                showError("No se puede mover sobre una carta cubierta");
                break;
        }
    }

    public void interact(FlipTableauCardController flipTableauCardController) {
        assert error == Error.ALREADY_FACE_UP;
        assert flipTableauCardController != null;
        showError("No se puede voltear una carta descubierta");
    }
}
