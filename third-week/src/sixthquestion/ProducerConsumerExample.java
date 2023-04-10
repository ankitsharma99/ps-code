package sixthquestion;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) {

        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();
    }

    static class Producer implements Runnable {

        @Override
        public void run () {
            for(int i = 1; i<=50; i++) {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ;
                System.out.println("Produced: " + i);
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run () {
            for(int i = 1; i<=50; i++) {
                Integer value = null;
                try {
                    value = queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Consumed: " + value);
            }
        }
    }
}
