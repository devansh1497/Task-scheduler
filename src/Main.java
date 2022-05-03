import datastore.DataStore;
import enums.Duration;
import model.Command;
import model.Delay;
import model.Recurrence;
import model.Task;
import model.TaskInput;
import model.TaskMetadata;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scheduler scheduler = Scheduler.getScheduler();
        SchedulerManager schedulerManager = new SchedulerManager(new DataStore());
        Recurrence recurrence = new Recurrence(1, Duration.SECONDS);
        TaskMetadata metadata1 = new TaskMetadata(recurrence);
        Command command = new Command("test command");
        Recurrence recurrence2 = new Recurrence(5, Duration.SECONDS);
        TaskMetadata metadata2 = new TaskMetadata(recurrence2);
        Command command2 = new Command("new command");
        schedulerManager.addTask(new TaskInput(new Task("task_1", metadata1, command), new Delay(5, Duration.SECONDS)));
        schedulerManager.addTask(new TaskInput(new Task("task_2", metadata2, command2), new Delay(2, Duration.SECONDS)));
    }
}
