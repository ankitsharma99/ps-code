package secondquestion;

//How to find duplicate elements in a given integers list in java using Stream functions?

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AllDuplicatesUsingStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4, 4, 5, 6, 5, 7, 1, 8, 8));

        Set<Integer> duplicates = list
                .stream()
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toSet());

        System.out.println(duplicates);
    }
}
