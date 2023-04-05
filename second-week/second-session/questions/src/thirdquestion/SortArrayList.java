package thirdquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 8, 10, 4, 6, 5, 1));
        Collections.sort(arrayList);
        System.out.println(arrayList);
    }
}
