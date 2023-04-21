package secondsession.firstquestion;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future = new CompletableFuture<>();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            future.complete("Hello, world!");
        }).start();

        future.thenAccept(System.out::println);

        System.out.println("Program is still running...");
    }
}
