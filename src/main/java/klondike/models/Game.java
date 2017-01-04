package klondike.models;

public class Game {

    private State state;

    public Game() {
        state = State.IN_GAME;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void reset() {

    }
}
