package fourthquetion;

class Task implements Runnable {
    @Override
    public void run() {
        for(int i = 1; i<=5; i++) {
            System.out.println(Thread.currentThread().getName() + " executing task: " + i);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class ThreadPriorityExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task(), "High Priority Thread");
        Thread t2 = new Thread(new Task(), "Low Priority Thread");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }
}
