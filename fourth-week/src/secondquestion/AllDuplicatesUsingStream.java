package secondquestion;

//How to find duplicate elements in a given integers list in java using Stream functions?

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AllDuplicatesUsingStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4, 4, 5, 6, 5, 7, 1, 8, 8));


        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}
