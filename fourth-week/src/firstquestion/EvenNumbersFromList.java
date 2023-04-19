package firstquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Given a list of integers, find out all the even numbers exist in the list using Stream functions?
public class EvenNumbersFromList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7));

        System.out.println(list.stream().filter(element -> (element%2 == 0)).collect(Collectors.toList()));
    }
}
