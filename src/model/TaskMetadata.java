package model;

import java.time.LocalDateTime;

public class TaskMetadata {
    private LocalDateTime createdOn;
    private LocalDateTime nextExecutionAt;
    private LocalDateTime lastExecutedAt;
    private Recurrence recurrence;

    public TaskMetadata() {
        this.createdOn = LocalDateTime.now();
    }

    public TaskMetadata(Recurrence recurrence) {
        this.createdOn = LocalDateTime.now();
        this.recurrence = recurrence;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getNextExecutionAt() {
        return nextExecutionAt;
    }

    public void setNextExecutionAt(LocalDateTime nextExecutionAt) {
        this.nextExecutionAt = nextExecutionAt;
    }

    public LocalDateTime getLastExecutedAt() {
        return lastExecutedAt;
    }

    public void setLastExecutedAt(LocalDateTime lastExecutedAt) {
        this.lastExecutedAt = lastExecutedAt;
    }

    public Recurrence getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(Recurrence recurrence) {
        this.recurrence = recurrence;
    }
}
