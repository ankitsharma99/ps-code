package fourthquetion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Request implements Runnable {
    private String name;
    private int priority;

    public Request (String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    @Override
    public void run () {
        double startTime = System.currentTimeMillis();
        Thread.currentThread().setPriority(this.priority);

        System.out.println(name + " started");

        int sum = 0;
        for(int i = 0; i<1000000000; i++) {
            sum += i;
        }
        double endTime = System.currentTimeMillis();
        System.out.println(name + " finished processing in " + (endTime - startTime) + " ms");
    }
}
public class ThreadPriorityReaLifeExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Request urgentRequest = new Request("Urgent Request", 10);
        Request normalRequest = new Request("Normal Request", 5);

        executorService.execute(urgentRequest);
        executorService.execute(normalRequest);

        executorService.shutdown();

    }
}
