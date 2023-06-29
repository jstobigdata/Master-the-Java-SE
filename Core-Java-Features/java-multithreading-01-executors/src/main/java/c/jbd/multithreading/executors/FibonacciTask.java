package c.jbd.multithreading.executors;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Integer> {

    private final int n;

    public FibonacciTask(int n){
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        FibonacciTask f1 = new FibonacciTask(n-1);
        f1.fork();

        FibonacciTask f2 = new FibonacciTask(n-2);
        f2.fork();

        return f2.join() + f1.join();
    }

    public static void main(String[] args) {
        // Create a new work-stealing pool with the default number of threads
        ForkJoinPool pool = ForkJoinPool.commonPool();

        // Compute Fibonacci(10) in parallel
        FibonacciTask task = new FibonacciTask(10);
        int result = pool.invoke(task);

        System.out.println("Fibonacci(10) = " + result);

        //wait for the tasks to complete
        pool.shutdown();
    }
}
