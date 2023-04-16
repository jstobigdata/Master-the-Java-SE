package com.jstobigdata.multithreading.ex2;

public class ThreadSleepWaitJoinExample {

    public static void main(String[] args) {
        //TODO - Uncomment each of the below line one at a time and check the behaviour

        //sleepThreadsExample();
        //joinThreadsExample();
        joinSleepThreadsExample();
        System.out.println(Thread.currentThread().getName());

    }

    public static void sleepThreadsExample(){
        //thread1 will complete the execution first then thread2
        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Blue Thread: " + i);
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
                System.out.println("Green Thread: " + i);
            }
        });

        thread1.start();
        thread2.start();
        System.out.println("============ Blue Thread first, then Green Thread =========");
    }

    public static void joinThreadsExample(){

        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Blue Thread: " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("Green Thread: " + i);
            }
        });

        thread1.start();
        thread2.start();

        System.out.println("============ Blue Thread first, then Green Thread =========");
    }

    public static void joinSleepThreadsExample(){

        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //System.out.println("Blue Thread: " + i);
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 5; i++) {
                //System.out.println("Green Thread: " + i);
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        });

        thread1.setName("Blue-Thread");
        thread2.setName("Green-Thread");
        thread1.start();
        thread2.start();

        System.out.println("============ Blue Threads with Delay first, then Green Thread =========");
    }
}
