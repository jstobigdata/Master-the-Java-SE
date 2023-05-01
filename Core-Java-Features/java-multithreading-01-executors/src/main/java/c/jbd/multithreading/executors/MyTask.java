package c.jbd.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTask implements Runnable {
    private int taskId;

    public MyTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task #" + taskId + " is running.");
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newWorkStealingPool();

        for (int i = 1; i <= 10; i++) {
            Runnable task = new MyTask(i);
            executor.submit(task);
        }

        executor.shutdown();
    }
}
