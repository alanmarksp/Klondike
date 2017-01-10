package klondike.controllers;

public enum Error {

    EMPTY_DECK("La baraja esta vacía"),
    EMPTY_WASTE("El descarte esta vacío"),
    EMPTY_FOUNDATION("El palo %s esta vacío"),
    EMPTY_TABLEAU_STACK("La escalear %s esta vacía"),
    NON_EMPTY_DECK("La baraja no esta vacía"),
    ORIGIN_CARD_FACE_DOWN("ERROR!!!"),
    DESTINATION_CARD_FACE_DOWN("ERROR!!!"),
    INVALID_MOVE("ERROR!!! No se puede poner %s sobre %s"),
    INVALID_NUM_CARDS_TO_MOVE("ERROR!!!"),
    ALREADY_FACE_UP("ERROR!!!");

    private String message;

    Error(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
