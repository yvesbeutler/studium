package ch.yvesbeutler.sed.design.stopwatch;

/**
 * @author yvesbeutler
 * Represents a simple stopwatch.
 */
public class Stopwatch implements StopwatchEventHandler {

    private long startTime;
    private State state;
    private Display display;

    @Override
    public void handleButton1() {
        state.handleButton1();
    }

    @Override
    public void handleButton2() {
        state.handleButton2();
    }

    public void start() {

    }

    public void stop() {

    }

    public void setState(State state) {
        this.state = state;
    }
}
