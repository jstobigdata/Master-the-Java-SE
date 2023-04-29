package com.jstobigdata.multithreading.ex5;

public class ObjectLockingExample {

    public static void main(String[] args) {
        //TODO - toggle comments and check
        testSynchronizedOnClass();
        //testObjectLocking();
    }

    public static void testSynchronizedOnClass(){
        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 50; i++) {
                ProblemWithSynchronized.incrementCounter1();
            }
        });

        Thread thread2 = new Thread(()-> {
            for (int i = 0; i < 50; i++) {
                ProblemWithSynchronized.incrementCounter2();
            }
        });

        thread1.start();
        thread2.start();
    }

    public static void testObjectLocking(){
        HandleWIthCustomObjectLocking class2 = new HandleWIthCustomObjectLocking();

        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 50; i++) {
                HandleWIthCustomObjectLocking.incrementWithLock1();
            }
        });

        Thread thread2 = new Thread(()-> {
            for (int i = 0; i < 50; i++) {
                HandleWIthCustomObjectLocking.incrementWithLock2();
            }
        });

        thread1.start();
        thread2.start();
    }
}
