import datastore.DataStore;
import model.Task;
import utils.ExecutionTimeUtils;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Scheduler {

    public static Scheduler scheduler = null;
    private static DataStore dataStore;
    static Set<Task> taskSet =
            Collections.synchronizedSet(new TreeSet<>(Comparator.comparing(a -> a.getMetadata().getNextExecutionAt())));

    public static Scheduler getScheduler() {
        if(scheduler == null) {
            dataStore = new DataStore();
            scheduler = new Scheduler();
        }
        loadAllTasks();
        return scheduler;
    }

    private static void loadAllTasks() {
        List<Task> tasks =
                dataStore.getTasks().stream().filter(task -> LocalDateTime.now().isBefore( task.getMetadata().getNextExecutionAt())).collect(Collectors.toList());
        tasks.clear();
        taskSet.addAll(tasks);
        new Thread(Scheduler::execute).start();
    }


    public static void execute() {
        while(true) {
            if(taskSet.size() > 0 && taskSet.stream().findFirst().get().getMetadata().getNextExecutionAt().isBefore(LocalDateTime.now())) {
                Task task = taskSet.stream().findFirst().get();
                taskSet.remove(task);
                new Thread(() -> {
                    System.out.println(task.getCommand().getCommand());
                    task.getMetadata().setLastExecutedAt(LocalDateTime.now());
                    ExecutionTimeUtils.calculateNextExecutionTime(task);
                    if(task.getMetadata().getNextExecutionAt() != null) {
                        taskSet.add(task);
                    }
                }).start(); ;
            }
        }
    }


}
