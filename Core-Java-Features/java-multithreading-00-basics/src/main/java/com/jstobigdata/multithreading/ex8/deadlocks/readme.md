- The thread should not block infinitely if it is unable to acquire lock
- so the tryLock() wukk help
- Make sure each thread acquires the lock in the same order to avoid the cyclic dependencies.
- Livelock can be handled with the methods above and some randomness
- threads retry acquiring the locks at random intervals

----
- In this example, we have two threads that acquire two different locks in different orders. Thread 1 acquires lock1 first and then lock2, while Thread 2 acquires lock2 first and then lock1. Both threads also introduce a small delay between acquiring the first lock and attempting to acquire the second lock.

- If Thread 1 acquires lock1 and Thread 2 acquires lock2 at around the same time, both threads will be blocked waiting for the other thread to release the lock they need. This will result in a deadlock, where neither thread can continue and the program will hang.

- To avoid deadlocks in Java, it's important to be careful when using synchronized blocks and to always acquire locks in the same order to prevent circular dependencies.


## Livelocks
- A livelock is a situation in which two or more processes or threads are stuck in a cycle of trying to resolve a conflict, but none of them can make progress. In a livelock, each process or thread is actively trying to resolve the conflict, but their actions prevent the others from making progress, so the situation persists indefinitely.

- Livelocks are similar to deadlocks, but in a deadlock, the processes or threads are blocked and unable to make progress, whereas in a livelock, they are constantly active but unable to resolve the conflict. Livelocks can be caused by a variety of factors, including communication failures, resource contention, and synchronization issues.

- To avoid livelocks, it's important to design systems with clear rules for resolving conflicts and to use synchronization mechanisms, such as locks and semaphores, to prevent multiple threads from accessing shared resources simultaneously. It's also important to monitor systems for livelock conditions and to use techniques such as backoff and retry to resolve conflicts when they occur.