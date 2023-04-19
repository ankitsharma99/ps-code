package sixthquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListOptional {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Rahul", "Rohit", "Virat", "Pant", "Bumrah");

        List<Integer> myList = null;
        Optional<List<Integer>> optional = Optional.ofNullable(myList);
        System.out.println(optional.isPresent());


        Optional<List<String>> optionalList = Optional.of(names);

        optionalList.ifPresent(list -> {
            if (!list.isEmpty()) {
                list.forEach(System.out::println);
            } else {
                System.out.println("The list is empty.");
            }
        });
    }
}
