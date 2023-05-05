package c.jbd.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkStealingPoolEx {
    private int taskId;

    public WorkStealingPoolEx(int taskId) {
        this.taskId = taskId;
    }

    public void action() {
        System.out.println("Task: %d started in %s".formatted(taskId, Thread.currentThread().getName()));
        try {
            //Simulate some real world behaviour
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task: %d completed in %s".formatted(taskId, Thread.currentThread().getName()));
    }

    public static void main(String[] args) throws InterruptedException {
        //Create a new work-stealing pool with the default no. of threads
        ExecutorService executor = Executors.newWorkStealingPool();

        executor.submit(new Thread(new WorkStealingPoolEx(1)::action));
        executor.submit(new Thread(new WorkStealingPoolEx(2)::action));
        executor.submit(new Thread(new WorkStealingPoolEx(3)::action));


        //wait for the activities to start
        executor.awaitTermination(10, TimeUnit.SECONDS);

        //wait for all the tasks to complete
        executor.shutdown();
    }
}
