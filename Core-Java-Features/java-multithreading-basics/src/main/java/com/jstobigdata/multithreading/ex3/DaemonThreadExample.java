package com.jstobigdata.multithreading.ex3;

//TODO - Complete this later
public class DaemonThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread daemonThread = new GenericWDThread("Daemon-Thread", true);
        Thread workerThread1 = new GenericWDThread("Worker-Thread1", false);
        Thread workerThread2 = new GenericWDThread("Worker-Thread2", false);

        daemonThread.start();
        workerThread1.start();
        //workerThread2.start();

        workerThread1.interrupt();
    }
}
