package com.jstobigdata.multithreading.ex1;

public class ThreadCreationsExample1 {
    public static void main(String[] args) {
        //TODO - Uncomment each of the below line one at a time and check the behaviour
        //simpleThreadCreations();
        //lambdaThreadCreation();

        threadsWithSleep();
    }

    public static void simpleThreadCreations() {
        //Creation of Thread from Runnable
        Thread thread1 = new Thread(new ThreadWithRunnable());

        //If the Thread class is directly extended
        Thread thread2 = new JbdThread();

        thread1.start();
        thread2.start();
    }

    public static void lambdaThreadCreation(){
        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadFromLambda-1: " + i);
            }

        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadFromLambda-2: " + i);
            }
        });

        thread1.start();
        thread2.start();

        System.out.println("======== Creating Threads using Lambda  ========");
    }

    public static void threadsWithSleep(){
        //thread1 will complete the execution first then thread2
        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadFromLambda-1: " + i);
            }

        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    //Sleep the thread for 100ms
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("ThreadFromLambda-2: " + i);
            }
        });

        thread1.start();
        thread2.start();
    }
}
