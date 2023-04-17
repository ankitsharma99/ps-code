package seventhquestion;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureAndCallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task = () -> {
            Thread.sleep(5000);
            return 10;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(task);

        Thread t1 = new Thread(futureTask);
        t1.start();

        System.out.println("Doing some work");

        int res = futureTask.get();
        System.out.println("The result is: " + res);


    }
}
