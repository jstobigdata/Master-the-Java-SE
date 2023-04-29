package com.jstobigdata.multithreading.ex10.semaphores;

import java.util.concurrent.Semaphore;

/**
 * In this example, we create a Semaphore object with 2 permits. We then create 4 threads that will run a Task object. Each Task object will attempt to acquire a permit from the semaphore by calling semaphore.acquire(). If a permit is available, the thread will print out that it has acquired a permit and then sleep for 1 second to simulate doing some work. Finally, the thread will release the permit back to the semaphore by calling semaphore.release(). If there are no permits available, the acquire() method will block the thread until a permit becomes available.
 *
 * Note that the output from this program will not be in a predictable order since the threads are executing asynchronously.
 */
public class SemaphoreExample {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2); // Initialize semaphore with permits = 2
        Thread t1 = new Thread(new Task(semaphore));
        Thread t2 = new Thread(new Task(semaphore));
        Thread t3 = new Thread(new Task(semaphore));
        Thread t4 = new Thread(new Task(semaphore));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static class Task implements Runnable {
        Semaphore semaphore;

        public Task(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire(); // Acquire a permit from the semaphore
                System.out.println(Thread.currentThread().getName() + " acquired a permit.");
                Thread.sleep(5000); // Do some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release(); // Release the permit back to the semaphore
                System.out.println(Thread.currentThread().getName() + " released the permit.");
            }
        }
    }
}
