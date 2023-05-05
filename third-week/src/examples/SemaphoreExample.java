package examples;

import java.util.concurrent.Semaphore;


public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1); // Create a semaphore with 1 permit

        Thread thread1 = new Thread(() -> {
            try {
                semaphore.acquire(); // Acquire the semaphore (i.e., wait for it to become available)
                System.out.println("Thread 1 acquired the semaphore!");
                Thread.sleep(5000);
                semaphore.release(); // Release the semaphore (i.e., make it available to another thread)
                System.out.println("Thread 1 released t.he semaphore!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 2 acquired the semaphore!");
                Thread.sleep(2000);
                semaphore.release();
                System.out.println("Thread 2 released the semaphore!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 3 acquired the semaphore!");
                Thread.sleep(3000);
                semaphore.release();
                System.out.println("Thread 3 released the semaphore!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
