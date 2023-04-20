package secondquestion;

//How to find duplicate elements in a given integers list in java using Stream functions?

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class CountGreaterThan implements Predicate<Map.Entry<Integer, Long>> {
    private final long count;
    public CountGreaterThan(long count) {
        this.count = count;
    }
    public boolean test(Map.Entry<Integer, Long> entry) {
        return entry.getValue() > count;
    }
}

class GetKey implements Function<Map.Entry<Integer, Long>, Integer> {
    public Integer apply(Map.Entry<Integer, Long> entry) {
        return entry.getKey();
    }
}

public class AllDuplicatesUsingStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4, 4, 5, 6, 5, 7, 1, 8, 8));

        Map<Integer, Long> counts = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // use objects with filter() and map()
        Predicate<Map.Entry<Integer, Long>> countGreaterThanOne = new CountGreaterThan(1);
        Function<Map.Entry<Integer, Long>, Integer> getKey = new GetKey();

        counts.entrySet().stream()
                .filter(countGreaterThanOne)
                .map(getKey)
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}



































//        list.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .filter(a -> a.getValue() > 1)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList()).forEach(System.out::println);
