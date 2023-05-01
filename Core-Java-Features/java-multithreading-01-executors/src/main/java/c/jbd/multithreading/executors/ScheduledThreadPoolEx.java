package c.jbd.multithreading.executors;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolEx {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(() -> {
            System.out.println("------ I say Hello in every 1 sec -----");
        }, 1, 2, TimeUnit.SECONDS);

        executor.schedule(() -> {
            System.out.println("===== Welcome to https://jstobigdata.com =====");
        }, 0, TimeUnit.SECONDS);

        executor.awaitTermination(10, TimeUnit.SECONDS);

        executor.shutdown();
    }
}
