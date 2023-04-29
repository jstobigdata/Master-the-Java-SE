package com.jstobigdata.multithreading.ex9.atomic;

/**
 * You will notice that the intCounter result is not as expected.
 */
public class NoAtomicIntegerProblem {

	private static int intCounter = 0;


	private static void incrementIntCounter() {
		for(int i=0;i<10000;i++)
			intCounter++;
	}
	
	public static void main(String[] args) {

		Thread t1 = new Thread(()-> {
			incrementIntCounter();
		});

		Thread t2 = new Thread(()-> {
			incrementIntCounter();
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Counter: "+intCounter);
	}

}