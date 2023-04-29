package com.jstobigdata.multithreading.ex6;

public class PCUsingSemaphoreExample {

    public static void main(String[] args) {
        PCUsingSemaphore producerConsumer = new PCUsingSemaphore();

        Thread consumer1 = new Thread(producerConsumer::consume);
        Thread producer1 = new Thread(producerConsumer::produce);

        consumer1.start();
        producer1.start();
    }
}
