package com.jstobigdata.multithreading.ex8.deadlocks;

/**
 * Deadlocks example using Semaphores
 */
public class DeadLocksB {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public void worker1(){
        synchronized(lock1) {
            System.out.println("======== Worker1 acquires the lock1 ========");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized(lock2) {
                System.out.println("======== Worker1 acquires the lock2 ========");
            }
        }
    }

    public void worker2(){
        synchronized(lock2) {
            System.out.println("======== Worker2 acquires the lock2 ========");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized(lock1) {
                System.out.println("======== Worker1 acquires the lock1 ========");
            }
        }
    }


    public static void main(String[] args) {
        DeadLocksB b = new DeadLocksB();
        Thread thread1 = new Thread(b::worker1);
        Thread thread2 = new Thread(b::worker2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
