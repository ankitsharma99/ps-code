package examples;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashmapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        for (int i = 0; i <100; i++) {
            new Thread(() -> {
                map.compute("A", (key, value) -> (value == null) ? 1 : value + 1);
            }).start();
        }

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Value for key 'A': " + map.get("A"));
    }
}
