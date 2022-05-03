import datastore.DataStore;
import model.Task;
import model.TaskInput;
import utils.ExecutionTimeUtils;
import utils.TimeUtils;


public class SchedulerManager {

    private DataStore dataStore;

    public SchedulerManager(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void addTask(TaskInput task) {
        if(task.getDelay() != null) {
            task.getTask().getMetadata().setNextExecutionAt(TimeUtils.addTime(task.getDelay().getDuration(),
                    task.getDelay().getDelay(), task.getTask().getMetadata().getCreatedOn()));
        }
        else{
            task.getTask().getMetadata().setNextExecutionAt(task.getTask().getMetadata().getCreatedOn());
        }
        dataStore.addTask(task.getTask());
        ExecutionTimeUtils.calculateNextExecutionTime(task.getTask());
        Scheduler.taskSet.add(task.getTask());
    }



}
