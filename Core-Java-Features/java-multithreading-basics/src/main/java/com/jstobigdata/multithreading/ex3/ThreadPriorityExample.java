package com.jstobigdata.multithreading.ex3;

//Java does not give you the absolute way to block threads, you can only set priority.
//The OS scheduler decides in the end.
public class ThreadPriorityExample {
    public static void main(String[] args) {
        Thread thread1 = new GenericWDThread("Thread1", false);
        Thread thread2 = new GenericWDThread("Thread2", false);
        Thread thread3 = new GenericWDThread("Thread3", false);

        thread1.setPriority(Thread.MAX_PRIORITY); //10
        thread2.setPriority(Thread.NORM_PRIORITY); //5
        thread3.setPriority(Thread.MIN_PRIORITY); //1

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
