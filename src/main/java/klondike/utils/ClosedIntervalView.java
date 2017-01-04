package klondike.utils;

class ClosedIntervalView {

    private String title;

    private ClosedInterval closedInterval;

    private IO io;

    ClosedIntervalView(String title, ClosedInterval closedInterval) {
        assert title != null;
        assert closedInterval != null;
        this.title = title;
        this.closedInterval = closedInterval;
        io = new IO();
    }

    void writeln() {
        io.writeln(title + " " + this.toString());
    }

    @Override
    public String toString() {
        return "[" + closedInterval.getMin() + ", " + closedInterval.getMax() + "]";
    }
}
