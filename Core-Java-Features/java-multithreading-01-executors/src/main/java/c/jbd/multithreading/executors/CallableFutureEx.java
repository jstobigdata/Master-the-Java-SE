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
        Thread.sleep(500); //just to imitate real work
        return "TaskId:"
            + this.taskId
            + " "
            + Thread.currentThread().getName();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> list = new ArrayList();


        for (int i = 0; i < 5; i++) {
            Future<String> future = executorService.submit(new CallableFutureEx(i));
            list.add(future);
        }

        for (Future<String> f:list){
            System.out.println(f.get());
        }

        executorService.shutdown();

    }
}


