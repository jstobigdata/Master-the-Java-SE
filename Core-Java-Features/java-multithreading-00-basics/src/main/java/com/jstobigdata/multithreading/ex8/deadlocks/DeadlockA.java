package com.jstobigdata.multithreading.ex8.deadlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockA {

	private Lock lockA = new ReentrantLock(true);
	private Lock lockB = new ReentrantLock(true);
	
	public static void main(String[] args) {
		
		DeadlockA deadlock = new DeadlockA();

		//TODO - Comment and uncomment worker2 and worker3 and test.
		new Thread(deadlock::worker1, "worker1").start();
		new Thread(deadlock::worker2, "worker2").start();
		//new Thread(deadlock::worker3, "worker3").start();


	}
	
	public void worker1() {
		lockA.lock();
		System.out.println("======== Worker1 acquires the lockA ========");
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		lockB.lock();
		System.out.println("======== Worker1 acquires the lockB ========");
		
		lockA.unlock();
		lockB.unlock();
	}
	
	public void worker2() {
		lockB.lock();
		System.out.println("======== Worker2 acquires the lockB ========");
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		lockA.lock();
		System.out.println("======== Worker2 acquires the lockA ========");
		
		lockB.unlock();
		lockA.unlock();
	}

	/*public void worker3() {
		lockA.lock();
		System.out.println("======== Worker3 acquires the lockA ========");

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		lockB.lock();
		System.out.println("======== Worker3 acquires the lockB ========");

		lockB.unlock();
		lockA.unlock();
	}*/
}
