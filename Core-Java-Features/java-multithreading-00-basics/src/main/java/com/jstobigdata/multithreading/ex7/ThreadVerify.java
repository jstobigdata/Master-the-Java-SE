package com.jstobigdata.multithreading.ex7;

/**
 * The code example is taken from: https://t.ly/k7Gu
 */
public class ThreadVerify {

    //TODO - Check the behaviour with and without volatile
    //public static volatile boolean stop = false;
    public static boolean stop = false;

    public static void main(String args[]) throws InterruptedException {

        Thread testThread = new Thread(()-> {
            int i = 1;
            while (!stop) {
                //Do not uncomment this
                //System.out.println("in thread: " + Thread.currentThread() + " i: " + i);
                i++;
            }
            System.out.println("Thread stop i=" + i);
        });

        testThread.start();
        Thread.sleep(1000);
        stop = true;
        System.out.println("now, in main thread stop is: " + stop);
        testThread.join();

        System.out.println("======= $1 ======".formatted(stop));
    }

}

