package c.jbd.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StopExecutorsEx {

    public static void main(String[] args) {
        usingShutdown();

        //TODO - Supported in JDK-19 onwards
        //usingTryWithResources();
    }

    private static void usingShutdown() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // submit some tasks to the executor

        // shutdown the executor
        executor.shutdown();
        try {
            // wait for all tasks to complete or timeout after 5 seconds
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                // forcibly shutdown the executor if tasks haven't completed after 5 seconds
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            // handle the exception
            throw new RuntimeException(e);
        }

    }

    //This code works in JDK-19
    /*private static void usingTryWithResources() {
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            // submit some tasks to the executor

        } catch (InterruptedException e) {
            // handle the exception
            throw new RuntimeException(e);
        }

    }*/

}
