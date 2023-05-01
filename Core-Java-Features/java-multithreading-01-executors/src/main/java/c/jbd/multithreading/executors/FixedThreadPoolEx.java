package c.jbd.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolEx implements Runnable{
    private int taskId;
    public FixedThreadPoolEx(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task: %d is running".formatted(taskId));
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(6);

        for (int i = 0; i < 10; i++) {
            executor.submit(new FixedThreadPoolEx(i));
        }
        executor.shutdown();
    }
}
