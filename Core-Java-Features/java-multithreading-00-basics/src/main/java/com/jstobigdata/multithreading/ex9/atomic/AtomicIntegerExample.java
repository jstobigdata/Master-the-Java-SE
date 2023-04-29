package com.jstobigdata.multithreading.ex9.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
	
	private static AtomicInteger counter = new AtomicInteger(0);
	
	public static void main(String[] args) {

		Thread t1 = new Thread(()->{
			incrementCounter();
		});
		
		Thread t2 = new Thread(()->{
			incrementCounter();
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Counter: "+counter);
		System.out.println("Counter: "+counter);

	}
	
	public static void incrementCounter() {
		for(int i=0;i<10000;i++)
			counter.getAndIncrement();
	}
}