package secondsession.thirdquestion;

import java.util.concurrent.*;
class SumTask extends RecursiveTask<Long> {
    private static final long THRESHOLD = 1000;
    private final long[] numbers;
    private final int start;
    private final int end;

    public SumTask(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            int mid = start + length / 2;
            SumTask leftTask = new SumTask(numbers, start, mid);
            SumTask rightTask = new SumTask(numbers, mid, end);
            leftTask.fork();
            long rightResult = rightTask.compute();
            long leftResult = leftTask.join();
            return leftResult + rightResult;
        }
    }


}

public class ForkJoinSumNumbers {
    public static void main(String[] args) {
        long[] numbers = new long[10000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        ForkJoinPool pool = ForkJoinPool.commonPool();
        SumTask task = new SumTask(numbers, 0, numbers.length);
        long result = pool.invoke(task);
        System.out.println("The sum is " + result);
    }
}
