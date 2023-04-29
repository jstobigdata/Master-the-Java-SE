package com.jstobigdata.multithreading.ex4;

public class SynchrinizationExample1 {
    public static void main(String[] args) throws InterruptedException {

        //TODO - Comment and Uncomment each line
        testNonSynchronised();
        //testSynchronizedCounter();
    }

    private static void testNonSynchronised(){
        Thread thread1 = new Thread(new com.jstobigdata.multithreading.ex4.Counter());
        Thread thread2 = new Thread(new com.jstobigdata.multithreading.ex4.Counter());
        Thread thread3 = new Thread(new com.jstobigdata.multithreading.ex4.Counter());

        thread1.start();
        thread2.start();
        //thread1.join();
        thread3.start();

        //Counter.print();
        //Counter.print();
        //Counter.print();
    }

    private static void testSynchronizedCounter(){
        Thread thread1 = new Thread(new com.jstobigdata.multithreading.ex4.SynchronizedCounter());
        Thread thread2 = new Thread(new com.jstobigdata.multithreading.ex4.SynchronizedCounter());
        Thread thread3 = new Thread(new com.jstobigdata.multithreading.ex4.SynchronizedCounter());

        thread1.start();
        thread2.start();
        //thread1.join();
        thread3.start();

        //SynchronizedCounter.print();
        //Counter.print();
        //Counter.print();
    }
}
