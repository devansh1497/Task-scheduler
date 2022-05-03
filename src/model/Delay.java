package model;

import enums.Duration;

public class Delay {
    private int delay;
    private Duration duration;

    public Delay(int delay, Duration duration) {
        this.delay = delay;
        this.duration = duration;
    }

    public int getDelay() {
        return delay;
    }

    public Duration getDuration() {
        return duration;
    }
}
