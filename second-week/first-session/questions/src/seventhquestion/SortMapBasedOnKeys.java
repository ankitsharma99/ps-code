package seventhquestion;

import java.util.*;

public class SortMapBasedOnKeys {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(7, "Dhoni");
        map.put(18, "Kohli");
        map.put(45, "Rohit");
        map.put(99, "Ashwin");

        System.out.println("Before sorting" + map);


        List<Integer> keys = new ArrayList<>(map.keySet());

        Collections.sort(keys);

        Map<Integer, String> sorted = new LinkedHashMap<>();        // linkedhashmap maintains the order of insertion

        for(Integer key: keys) {
            sorted.put(key, map.get(key));
        }

        System.out.println("Sorted map: ");
        for(Map.Entry<Integer, String> e: sorted.entrySet()) {
            System.out.print(e.getKey() + ": " + e.getValue() + " ");
        }



    }
}
