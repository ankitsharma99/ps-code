package firstsession.fifthquestion;

import java.util.Arrays;
import java.util.List;

//Given a list of integers, find the maximum value element present in it using Stream functions?
public class MaximumFromList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 7, 23, 4, 45, 92, 12, 53);
        Integer max = numbers.stream().max(Integer::compareTo).orElse(null);
        System.out.println("Maximum value element present in the list: " + max);
    }
}
