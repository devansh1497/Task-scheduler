package model;

public class TaskInput {

    private Task task;
    private Delay delay;

    public TaskInput(Task task, Delay delay) {
        this.task = task;
        this.delay = delay;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Delay getDelay() {
        return delay;
    }

    public void setDelay(Delay delay) {
        this.delay = delay;
    }
}
