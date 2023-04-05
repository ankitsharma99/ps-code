package sixthquestion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;



public class CompareHashSets {
    public static void main(String[] args) {
        HashSet<Integer> hashSet1 = new HashSet<>(Arrays.asList(1, 4, 5, 3, 2, 5, 5, 5, 5));
        HashSet<Integer> hashSet2 = new HashSet<>(Arrays.asList(1, 1, 1, 1, 1, 5, 2, 4, 3));
        System.out.println(hashSet1.equals(hashSet2));
    }
}
