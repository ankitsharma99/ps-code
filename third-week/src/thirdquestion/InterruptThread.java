package thirdquestion;

class InterruptingThreadExample extends Thread {
    static int threadCnt = 0;
    public void run() {
        try {
            while(!isInterrupted()) {
                System.out.println("Thread running with thread count: " + ++threadCnt );
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            System.out.println("Your thread was interrupted");
            e.printStackTrace();
        }
    }
}
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        InterruptingThreadExample interruptingThreadExample = new InterruptingThreadExample();
        interruptingThreadExample.start();
        Thread.sleep(10000);
        interruptingThreadExample.interrupt();
    }
}
