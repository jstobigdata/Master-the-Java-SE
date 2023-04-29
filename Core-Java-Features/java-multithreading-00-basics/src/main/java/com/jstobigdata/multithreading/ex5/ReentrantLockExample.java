package com.jstobigdata.multithreading.ex5;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private Lock lock = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    private static int counter1 = 0;
    private static int counter2 = 0;

    public void incrementCounter1(){

        lock.lock(); //better to use lock.tryLock()
        try{
            System.out.println("Counter1-"+Thread.currentThread().getName() +": " + counter1++);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void incrementCounter2(){
        if(lock2.tryLock()) {
            try {
                System.out.println("Counter2-"+Thread.currentThread().getName() +": " + counter2++);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock2.unlock();
            }
        } else {
            System.out.println("---- Unable to acquire the Lock ---");
        }
    }

    public static void main(String[] args) {

        ReentrantLockExample example = new ReentrantLockExample();

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                example.incrementCounter1();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                example.incrementCounter2();
            }
        });
        Thread t3 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                example.incrementCounter1();
            }
        });
        Thread t4 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                example.incrementCounter2();
            }
        });


        //TODO - Change the nThreads - to 1,2,4,5,8

       Executor executor = Executors.newFixedThreadPool(8);
       executor.execute(t1);
       executor.execute(t2);
       executor.execute(t3);
       executor.execute(t4);

    }

}
