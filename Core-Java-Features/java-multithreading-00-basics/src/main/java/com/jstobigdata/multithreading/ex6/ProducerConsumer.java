package com.jstobigdata.multithreading.ex6;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer{

    private List<Integer> buffer = new LinkedList<>();
    private final int MAX_SIZE = 5;

    public void produce() throws InterruptedException {
        while (true){
            synchronized (this){
                while(buffer.size() == MAX_SIZE){
                    wait();
                }
                int value = this.generateRandom();
                buffer.add(value);
                System.out.println("Produced: " + value);
                notifyAll();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true){
            Thread.sleep(3000);
            synchronized (this){
                while(buffer.isEmpty()){
                    wait();
                }
                int value = buffer.remove(0);
                System.out.println("Consumed: "+ value);
                notifyAll();
            }
        }
    }


    private int generateRandom(){
        return (int)(Math.random()*100);
    }

}
