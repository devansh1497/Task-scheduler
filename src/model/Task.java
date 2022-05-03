package model;

import java.util.Objects;
import java.util.UUID;

public class Task {
    private String name;
    private TaskMetadata metadata;
    private Command command;

    public Task(String name, TaskMetadata metadata, Command command) {
        this.name = name;
        this.metadata = metadata;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(TaskMetadata metadata) {
        this.metadata = metadata;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return getName().equals(task.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
