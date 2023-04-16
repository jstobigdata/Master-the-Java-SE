package com.jstobigdata.multithreading.ex4;

public class SynchronizedCounter implements Runnable {

    private static Integer counter = 0;

    @Override
    public void run() {
        synchronized (counter) {
            for (int i = 0; i < 100; i++) {
                System.out.println("Counter: " + counter);
                counter++;
            }
        }

        //Some more ways to use synchronized
        /*synchronized (SynchronizedCounter.class) {
            for (int i = 0; i < 100; i++) {
                System.out.println("Counter: " + counter);
                counter++;
            }
        }*/
    }
}
