package model;

import enums.Duration;

public class Recurrence {
    private int value;
    private Duration duration;

    public Recurrence(int value, Duration duration) {
        this.value = value;
        this.duration = duration;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
