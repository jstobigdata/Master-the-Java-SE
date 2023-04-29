package com.jstobigdata.multithreading.ex6;

// Using Wait and Notify for ProducerConsumer Problem
/*

lock() and tryLock() are two methods of the Java Lock interface that allow you to acquire a lock on a shared resource to protect it from concurrent access by multiple threads.

The main difference between lock() and tryLock() is that lock() will block the calling thread until the lock is acquired, while tryLock() will try to acquire the lock and immediately return a boolean indicating whether the lock was acquired or not.

Here's an example to illustrate the difference between lock() and tryLock():



In the incrementSharedResourceWithLock() method, the lock() method is called to acquire the lock. This method will block the calling thread until the lock is acquired, which can potentially cause performance issues if the lock is held for a long time.

In the incrementSharedResourceWithTryLock() method, the tryLock() method is called to try to acquire the lock. This method immediately returns a boolean indicating whether the lock was acquired or not. If the lock was acquired, the critical section is executed, and the method returns true. Otherwise, the method returns false.

tryLock() is useful when you want to avoid blocking the calling thread and need to perform some other action if the lock cannot be acquired, such as retrying later or taking some other course of action.

However, it's important to note that using tryLock() can potentially result in a livelock situation where multiple threads continuously attempt to acquire the lock without making progress. To avoid this, you can use the tryLock(long time, TimeUnit unit) method, which will try to acquire the lock for a specified amount of time before giving up and returning false.


 */