package klondike.models;

public enum SpanishCardValue implements CardValue {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    TEN("10"),
    ELEVEN("11"),
    TWELVE("12");

    private String message;

    SpanishCardValue(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    @Override
    public boolean isMaxValue() {
        return this == SpanishCardValue.TWELVE;
    }

    @Override
    public boolean isMinValue() {
        return this == SpanishCardValue.ONE;
    }

}
