package com.jstobigdata.multithreading.ex6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class PCUsingSemaphore{

    private final int MAX_SIZE = 5;
    private List<Integer> buffer = new ArrayList<>(MAX_SIZE);


    private Semaphore producerSemaphore = new Semaphore(MAX_SIZE);
    private Semaphore consumerSemaphore = new Semaphore(0);

    public void produce(){
        while (true){
            try{
                producerSemaphore.acquire();
                int value = this.generateRandom();
                buffer.add(value);
                System.out.println("Produced: " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                consumerSemaphore.release();
            }
        }
    }

    public void consume(){
        while(true){
            try {
                Thread.sleep(3000); //just sleep for 3 secs to behave as a slow thread
                consumerSemaphore.acquire();
                int value = buffer.remove(0);
                System.out.println("Consumer: " + value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                producerSemaphore.release();
            }
        }
    }

    private int generateRandom(){
        return (int)(Math.random()*100);
    }
}
