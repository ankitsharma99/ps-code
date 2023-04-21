package secondsession.fourthquestion;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class FibonacciTask extends RecursiveAction {
    private final int n;
    private long result;

    public FibonacciTask(int n) {
        this.n = n;
    }

    public long getResult() {
        return result;
    }

    @Override
    protected void compute() {
        if (n <= 1) {
            result = n;
        } else {
            FibonacciTask leftTask = new FibonacciTask(n - 1);
            FibonacciTask rightTask = new FibonacciTask(n - 2);
            leftTask.fork();
            rightTask.compute();
            leftTask.join();
            result = leftTask.getResult() + rightTask.getResult();
        }
    }


}

public class RecursiveActionFibonacci {
    public static void main(String[] args) {
        int n = 10;
        FibonacciTask task = new FibonacciTask(n);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        System.out.println("The Fibonacci number at position " + n + " is " + task.getResult());
    }
}
