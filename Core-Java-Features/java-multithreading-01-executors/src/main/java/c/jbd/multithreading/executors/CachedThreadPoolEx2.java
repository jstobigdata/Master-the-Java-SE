package c.jbd.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolEx2 {

    public static void main(String[] args) {
        // Create a CachedThreadPool with no maximum size limit
        ExecutorService executor = Executors.newCachedThreadPool();

        // Submit 10 tasks to the executor
        for (int i = 1; i <= 10; i++) {
            executor.submit(new Task(i));
        }

        // Shutdown the executor when all tasks have completed
        executor.shutdown();
    }

    private static class Task implements Runnable {
        private final int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Task #" + taskId + " is running on thread " + Thread.currentThread().getName());
        }
    }
}
