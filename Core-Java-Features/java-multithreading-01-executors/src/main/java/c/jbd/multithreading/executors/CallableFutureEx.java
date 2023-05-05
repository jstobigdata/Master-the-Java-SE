package c.jbd.multithreading.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableFutureEx implements Callable<String> {

    private int taskId;

    public CallableFutureEx(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String call() throws Exception {
        //Just to imitate a real-world behaviour
        Thread.sleep(500);
        return "TaskId: %d completed in %s"
                .formatted(taskId, Thread.currentThread().getName());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<String>> list = new ArrayList();

        for (int i = 0; i < 5; i++) {
            Future<String> future = executor.submit(new CallableFutureEx(i));
            list.add(future);
        }

        for (Future<String> f : list) {
            System.out.println(f.get());
        }

        executor.shutdown();
    }
}
