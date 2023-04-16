package com.jstobigdata.multithreading.ex5;

public class ProblemWithSynchronized{

    private static int counter1 = 0;
    private static int counter2 = 0;

    public static void incrementCounter1(){
        synchronized (ProblemWithSynchronized.class) {
            System.out.println("Counter1: "+counter1++);
        }
    }

    public static void incrementCounter2(){
        synchronized (ProblemWithSynchronized.class){
            System.out.println("Counter2: "+ counter2++);
        }
    }

}
