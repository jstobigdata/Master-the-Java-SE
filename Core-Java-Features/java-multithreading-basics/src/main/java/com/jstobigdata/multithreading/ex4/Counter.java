package com.jstobigdata.multithreading.ex4;

public class Counter implements Runnable {
    private static int counter = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Counter: " + counter);
            counter++;
        }
    }

    public static void print(){
        System.out.println("Counter: " + counter);
    }
}
