package c.jbd.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolEx {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task: %d in %s started".formatted(taskId, Thread.currentThread().getName()));
                try {
                    //Just to simulate some actual work
                    //Thread.sleep(5000);
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task: %d in %s completed".formatted(taskId, Thread.currentThread().getName()));
            });
        }

        executor.shutdown();
    }
}
