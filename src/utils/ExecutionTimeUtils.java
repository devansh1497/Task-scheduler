package utils;

import model.Task;

import java.time.LocalDateTime;

public class ExecutionTimeUtils {

    public static void calculateNextExecutionTime(Task task) {
        if(task.getMetadata().getRecurrence() == null) {
            task.getMetadata().setNextExecutionAt(null);
        }
        else {
            LocalDateTime time;
            if(task.getMetadata().getLastExecutedAt() == null) {
                time = task.getMetadata().getCreatedOn();
            }
            else{
                time = task.getMetadata().getLastExecutedAt();
            }
            task.getMetadata().setNextExecutionAt(TimeUtils.addTime(task.getMetadata().getRecurrence().getDuration(),
                    task.getMetadata().getRecurrence().getValue(), time));
        }
    }
}
