package sixthquestion;

import java.util.ArrayList;
import java.util.List;

class Producer implements Runnable {
    private List<Integer> buffer;
    private int bufferSize;
    private int cnt = 0;
    private int maxExecutions;

    public Producer(List<Integer> buffer, int bufferSize, int maxExecutions) {
        this.buffer = buffer;
        this.bufferSize = bufferSize;
        this.maxExecutions = maxExecutions;
    }

    public void produce(int value) {
        synchronized (buffer) {     // synchronize shared buffer
            while(buffer.size() >= bufferSize) {
                try {
                    buffer.wait();      // asks buffer to wait until consumer consumes as shared buffer is full
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer.add(value);      // add new values
            System.out.println("Produced: " + value);
            buffer.notifyAll();     // notify the consumer buffer to consume
        }
    }

    @Override
    public void run() {
        while(cnt <= maxExecutions) {
            produce(cnt++);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private List<Integer>   buffer;
    private int maxExecutions;
    private int cnt = 0;
    public Consumer(List<Integer> buffer, int maxExecutions) {
        this.buffer = buffer;
        this.maxExecutions = maxExecutions;
    }

    public void consume() {
        synchronized (buffer) {
            while(buffer.isEmpty()) {
                try {
                    buffer.wait();      // wait for the producer to add items to the buffer
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int value = buffer.remove(0);
            System.out.println("Consumed: " + value);       // consume from the shared buffer
            buffer.notifyAll();
        }
    }

    @Override
    public void run () {
        while(cnt <= maxExecutions) {
            consume();
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            cnt++;
        }
    }
}

public class ProducerAndConsumerSynchronizedExample {
    public static void main(String[] args) {
        List<Integer> buffer = new ArrayList<>();       // shared buffer to pass data between producer and consumer
        int bufferSize = 5;     // max size of shared buffer
        int maxExecutions = 10;     // will run total 10 times

        Thread producer = new Thread(new Producer(buffer, bufferSize, maxExecutions));
        Thread consumer = new Thread(new Consumer(buffer, maxExecutions));

        producer.start();
        consumer.start();
    }
}
