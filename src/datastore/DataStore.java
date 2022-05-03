package datastore;

import model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataStore {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }

    public void getTask(Task task) {
        this.tasks.stream().filter(t -> t == task).collect(Collectors.toList()).get(0);
    }

    public List<Task> getTasks() {
        return this.tasks;
    }
}
