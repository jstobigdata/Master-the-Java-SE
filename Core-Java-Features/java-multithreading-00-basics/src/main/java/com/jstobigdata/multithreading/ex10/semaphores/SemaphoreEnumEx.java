package com.jstobigdata.multithreading.ex10.semaphores;

import java.util.concurrent.Semaphore;

/**
 * In this example, we define an Enum called Resource to represent the resources being controlled by the Semaphore. Each resource has a number of permits associated with it, which we define in the constructor of the Enum.
 *
 * We then create a Semaphore for each resource and initialize them with the number of permits defined in the Enum.
 *
 * In the Task class, we pass in a variable number of Resource parameters to specify which resources the task needs to acquire. In the run() method, we use a for loop to acquire all the required semaphores based on the Resource parameters. We then do some work (simulated by sleeping for 1 second) and release all the acquired semaphores in reverse order using another for loop based on the Resource parameters.
 *
 * Note that the output from this program will not be in a predictable order since the threads are executing asynchronously.
 */
public class SemaphoreEnumEx {

    enum Resource {
        CPU(1), DISK(2), RAM(2);

        private final int permits;

        Resource(int permits) {
            this.permits = permits;
        }

        public int getPermits() {
            return permits;
        }
    }

    // A Semaphore for each resource
    private static Semaphore cpuSemaphore = new Semaphore(Resource.CPU.getPermits());
    private static Semaphore diskSemaphore = new Semaphore(Resource.DISK.getPermits());
    private static Semaphore memorySemaphore = new Semaphore(Resource.RAM.getPermits());

    private Resource[] resources;


    public SemaphoreEnumEx(Resource... resources) {
        this.resources = resources;
    }

    private void action() {
        try {
            for (Resource resource : resources) {
                switch (resource) {
                    case CPU:
                        cpuSemaphore.acquire();
                        break;

                    case DISK:
                        diskSemaphore.acquire();
                        break;

                    case RAM:
                        memorySemaphore.acquire();
                        break;
                }
                System.out.println(Thread.currentThread().getName() + " acquired " + resource);
            }

            //perform some relevant work
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            for (Resource resource : resources) {
                System.out.println(Thread.currentThread().getName() + " will release: " + resource);
                switch (resource) {
                    case CPU:
                        cpuSemaphore.release();
                        break;

                    case DISK:
                        diskSemaphore.release();
                        break;

                    case RAM:
                        memorySemaphore.release();
                        break;
                }
                System.out.println(Thread.currentThread().getName() + " released " + resource);
            }
        }
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new SemaphoreEnumEx(Resource.CPU)::action); //Thread-0
        Thread t2 = new Thread(new SemaphoreEnumEx(Resource.DISK)::action);
        Thread t3 = new Thread(new SemaphoreEnumEx(Resource.RAM)::action);

        Thread t4 = new Thread(new SemaphoreEnumEx(Resource.CPU, Resource.RAM)::action);
        Thread t5 = new Thread(new SemaphoreEnumEx(Resource.RAM, Resource.DISK)::action);
        Thread t6 = new Thread(new SemaphoreEnumEx(Resource.CPU, Resource.RAM, Resource.DISK)::action);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
