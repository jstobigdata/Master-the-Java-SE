package com.jstobigdata.multithreading.ex7;

/**
 * In Java, the volatile keyword is used to indicate that a variable's value may be modified
 * by multiple threads, and therefore must be synchronized across threads to ensure consistency.
 *
 * Here is an example of using the volatile keyword in Java:
 */
public class VolatileExample {

    //TODO - remove volatile and check
    private  int count = 0;

    public void increment() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("Counter-%s: %s".formatted(Thread.currentThread().getName(), count++));
        }

    }

    public void printCount() {
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        Thread t1 = new Thread(example::increment);
        Thread t2 = new Thread(example::increment);
        Thread t3 = new Thread(example::printCount);
        Thread t4 = new Thread(example::printCount);
        Thread t5 = new Thread(example::printCount);
        Thread t6 = new Thread(example::printCount);

        t6.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
