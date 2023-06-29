package c.jbd.multithreading.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutorEx {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        executor.scheduleAtFixedRate(() -> {
            System.out.println("======= Welcome to Jstobigdata ======");
        },0,2, TimeUnit.SECONDS);

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task: %d in %s started".formatted(taskId, Thread.currentThread().getName()));
                try {
                    //Do some actual work for 2 sec
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task: %d in %s completed".formatted(taskId, Thread.currentThread().getName()));
            });
        }

        executor.schedule(() -> {
            System.out.println("===== This message comes in the end =====");
        }, 2, TimeUnit.SECONDS);

        executor.awaitTermination(30, TimeUnit.SECONDS);

        executor.shutdown();
    }
}
