
public class ThreadSafetyCheckStringBuffer {
    public static void main(String[] args) throws InterruptedException {
        StringBuffer sBuff = new StringBuffer();

        Thread thread1 = new SpringBufferThread(sBuff, "Good");
        Thread thread2 = new SpringBufferThread(sBuff, "Evening");
        Thread thread3 = new SpringBufferThread(sBuff, "All");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(sBuff);
    }

}


class SpringBufferThread extends Thread{
    private StringBuffer sBuff;
    private String str;
    SpringBufferThread (StringBuffer sBuff, String str) {
        this.sBuff = sBuff;
        this.str = str;
    }

    @Override
    public void run() {
        sBuff.append(str);
    }
}