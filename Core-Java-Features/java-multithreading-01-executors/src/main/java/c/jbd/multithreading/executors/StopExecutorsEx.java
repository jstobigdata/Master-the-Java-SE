package c.jbd.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StopExecutorsEx {
    public static void main(String[] args) {

    }

    //for JDK before 19
    private static void usingShutdown() {
        //Create the thread pool
        ExecutorService executor = Executors.newSingleThreadExecutor();

        //add/submit for tasks for execution

        //shutdown the executor
        executor.shutdown();

        try {
            //wait for all tasks to complete or timeout after 5 seconds
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdown(); //forcefully shutdown
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    //for jdk above 19
   /* private static void usingTryWithResource() {
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/
}
