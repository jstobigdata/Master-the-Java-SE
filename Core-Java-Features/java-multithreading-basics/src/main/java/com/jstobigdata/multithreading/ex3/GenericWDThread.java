package com.jstobigdata.multithreading.ex3;

public class GenericWDThread extends Thread{

    public GenericWDThread(String threadName, boolean isDaemon) {
        this.setName(threadName);
        this.setDaemon(isDaemon);

    }

    @Override
    public void run() {
        for (int i=0; i<11; i++){
            System.out.println("This is: " + this.getName() + " - " + i);
        }
    }
}
