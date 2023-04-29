package com.jstobigdata.multithreading.ex5;

/**
 * Better ways to Handle with custom Objects
 */

public class HandleWIthCustomObjectLocking {
    private static int counter1 = 0;
    private static int counter2 = 0;

    private static final Object OBJ_LOCK_1 = new Object();
    private static final Object OBJ_LOCK_2 = new Object();


    //Better way to handle synchronized
    public static void incrementWithLock1() {
        synchronized (OBJ_LOCK_1) {
            System.out.println("Counter1: " + counter1++);
        }
    }

    public static void incrementWithLock2() {
        synchronized (OBJ_LOCK_2) {
            System.out.println("Counter2: " + counter2++);
        }
    }
}
