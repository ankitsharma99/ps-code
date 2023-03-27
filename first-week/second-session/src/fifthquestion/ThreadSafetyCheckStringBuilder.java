package fifthquestion;

public class ThreadSafetyCheckStringBuilder {
    public static void main(String[] args) throws InterruptedException {
        StringBuilder sBuild = new StringBuilder();

        Thread thread1 = new SpringBuilderThread(sBuild, "Good");
        Thread thread2 = new SpringBuilderThread(sBuild, "Evening");
        Thread thread3 = new SpringBuilderThread(sBuild, "All");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(sBuild);
    }
}
