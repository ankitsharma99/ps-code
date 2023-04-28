package fifthquestion;
// program to implement all types of Executors

import java.util.concurrent.*;

class Task implements Runnable {
    private String name;

    public Task (String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing " + name);
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " completed " +  name );
    }
}
public class AllExecutorImplementation {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        // will run in the same order
        singleThreadExecutor.execute(new Task("SingleThreadExecutor task 1"));
        singleThreadExecutor.execute(new Task("SingleThreadExecutor task 2"));
//        singleThreadExecutor.shutdown();
        if(!singleThreadExecutor.awaitTermination(120, TimeUnit.SECONDS)) {
            singleThreadExecutor.shutdownNow();
        }

//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
//        fixedThreadPool.execute(new Task("FixedThreadPool Task 1"));
//        fixedThreadPool.execute(new Task("FixedThreadPool Task 2"));
//        fixedThreadPool.execute(new Task("FixedThreadPool Task 3"));        // this will wait until line 37 or 38 thread executes
//        fixedThreadPool.shutdown();
//
//
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        cachedThreadPool.execute(new Task("CachedThreadPool Task 1"));
//        cachedThreadPool.execute(new Task("CachedThreadPool Task 2"));
//        cachedThreadPool.execute(new Task("CachedThreadPool Task 3"));
//        cachedThreadPool.shutdown();
//
//
//        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
//        // can run after some delay or executes periodically, returns a ScheduledFuture
//        ScheduledFuture<?> scheduledFuture = scheduledThreadPool.schedule(new Task("ScheduledThreadPool Task 1"), 5, TimeUnit.SECONDS);
//        scheduledThreadPool.schedule(new Task("ScheduledThreadPool Task 2"), 3, TimeUnit.SECONDS);
//
//        scheduledThreadPool.scheduleAtFixedRate(new Task("FixedScheduledThreadPool Task 3"), 1, 1, TimeUnit.SECONDS);
//        scheduledThreadPool.scheduleAtFixedRate(new Task("FixedScheduledThreadPool Task 4"), 2, 2, TimeUnit.SECONDS);
//
//        try {
//            scheduledFuture.get();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        scheduledThreadPool.shutdown();

    }
}
