package c.jbd.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkStealingPoolExample {

    public void action(int taskId) {
        System.out.println("Task %d started".formatted(taskId));
        try {
            Thread.sleep(1000); // simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task %d completed".formatted(taskId));
    }


    public static void main(String[] args) throws InterruptedException {

        // Create a new work-stealing pool with the default number of threads
        ExecutorService pool = Executors.newWorkStealingPool();

        // Submit some tasks to the pool
        pool.submit(() -> {
            System.out.println("Task 1 started");
            try {
                Thread.sleep(1000); // simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 1 completed");
        });

        pool.submit(() -> {
            System.out.println("Task 2 started");
            try {
                Thread.sleep(500); // simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 2 completed");
        });

        pool.submit(() -> {
            System.out.println("Task 3 started");
            try {
                Thread.sleep(500); // simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 3 completed");
        });

        pool.awaitTermination(10, TimeUnit.SECONDS);

        // Wait for all tasks to complete
        pool.shutdown();
    }
}
