package secondsession.secondquestion;

import java.util.concurrent.CompletableFuture;

public class ComputableFutureWithSupplyAsync {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> fetchData());
        future.thenAccept(s -> System.out.println(s));
        System.out.println("Program is still running");
        Thread.sleep(3000);
    }

    private static String fetchData() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, world!";
    }

}
