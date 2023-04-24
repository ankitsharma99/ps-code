package secondsession.fourthquestion;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


class FibonacciTask extends RecursiveAction {
    private int n;
    private long[] fib;

    public FibonacciTask(int n, long[] fib) {
        this.n = n;
        this.fib = fib;
    }

    @Override
    protected void compute() {
        if (n <= 1) {
            fib[n] = n;
            return;
        }

        FibonacciTask left = new FibonacciTask(n - 1, fib);
        FibonacciTask right = new FibonacciTask(n - 2, fib);

        invokeAll(left, right);

        fib[n] = fib[n - 1] + fib[n - 2];
    }
}

public class RecursiveActionFibonacci {
    public static void main(String[] args) {
        int n = 6;
        long[] fib = new long[n + 1];

        FibonacciTask task = new FibonacciTask(n, fib);
        task.invoke();

        System.out.println("Fibonacci(" + n + ") = " + fib[n]);
    }
}
