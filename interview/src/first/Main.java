package first;

import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class MaxOccurringCharacter implements Serializable {
    public static char getMaxOccurringChar(String input) {
        if(input.isEmpty() || input == null) {
            throw new IllegalArgumentException("Input should not be null or empty");
        }

        int[] count = new int[256];
        for(int i = 0; i<input.length(); i++) {
            count[input.charAt(i)]++;
        }

        int maxCharFreq = Integer.MIN_VALUE;
        char maxChar = 0;


        for(int i = 0; i<input.length(); i++) {
            char curChar = input.charAt(i);
            if(count[curChar] > maxCharFreq) {
                maxCharFreq = count[curChar];
                maxChar = curChar;
            }
        }

        return maxChar;
    }

}

//class MyComparator implements Comparator<MyImmutableClass> {
//
//}
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the string:");
//        String input = scanner.next();
//        System.out.println(MaxOccurringCharacter.getMaxOccurringChar(input));

        List<MyImmutableClass> list = new ArrayList<>();

        Predicate<MyImmutableClass> p = (o) -> o.getAge() > 20;

        Collections.sort(list, (o1, o2) -> {
            return o1.getAge() - o2.getAge();
        });

        list.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).collect(Collectors.toList()).forEach(System.out::println);

    }

}
