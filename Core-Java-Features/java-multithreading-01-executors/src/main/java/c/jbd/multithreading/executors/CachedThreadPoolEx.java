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
                    //Do some actual work for 5 sec
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task: %d in %s completed".formatted(taskId, Thread.currentThread().getName()));
            });
        }

        executor.shutdown();
    }
}
