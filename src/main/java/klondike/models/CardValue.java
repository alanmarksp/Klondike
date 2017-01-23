package klondike.models;

public interface CardValue {

    String toString();

    boolean isMaxValue();

    boolean isMinValue();

    int ordinal();
}
