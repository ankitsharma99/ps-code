package firstquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//Given a list of integers, find out all the even numbers exist in the list using Stream functions?
class EvenPredicate implements Predicate<Integer> {

    @Override
    public boolean test(Integer integer) {
        return integer%2 == 0;
    }
}
public class EvenNumbersFromList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7));
        EvenPredicate evenPredicate = new EvenPredicate();

        list.stream().filter(evenPredicate).collect(Collectors.toList()).forEach(System.out::println);
    }
}
