package com.jstobigdata.multithreading.ex1;

public class ThreadWithRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadWithRunnable: " + i);
        }
    }
}

class JbdThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("JbdThread: " + i);
        }
    }
}
