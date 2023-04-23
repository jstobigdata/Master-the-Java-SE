package com.jstobigdata.multithreading.ex8.deadlocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class LivelockExample {

	private Lock lock1 = new ReentrantLock(true);
	private Lock lock2 = new ReentrantLock(true);

	public static void main(String[] args) {
		LivelockExample livelock = new LivelockExample();
		new Thread(livelock::operation1, "T1").start();
		new Thread(livelock::operation2, "T2").start();
	}

	public void operation1() {
		while (true) {
			boolean l1 = tryLock(lock1,50);
			System.out.println("===== lock1 acquired: %s, trying to acquire lock2. =====".formatted(l1));
			sleep(50);

			if (tryLock(lock2, 0)) {
				print("===== lock2 acquired. =====");
			} else {
				print("===== cannot acquire lock2, releasing lock1. =====");
				lock1.unlock();
				continue;
			}

			print("===== Executing first operation. =====");
			break;
		}
		lock2.unlock();
		lock1.unlock();
	}

	public void operation2() {
		while (true) {
			boolean l2 = tryLock(lock2, 50);
			print("===== lock2 acquired: %s, trying to acquire lock1. =====".formatted(l2));
			sleep(50);

			if (tryLock(lock1, 0)) {
				print("===== lock1 acquired. =====");
			} else {
				print("===== cannot acquire lock1, releasing lock2. =====");
				lock2.unlock();
				continue;
			}

			print("===== Executing second operation. =====");
			break;
		}
		lock1.unlock();
		lock2.unlock();
	}

	// helper methods

	public boolean tryLock(Lock lock, int time) {
		try {
			return lock.tryLock(time, TimeUnit.MILLISECONDS);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void print(String str){
		System.out.println(str);
	}

	public void sleep(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}