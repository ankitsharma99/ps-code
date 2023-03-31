package fourthquestion;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class ReverseOrderLinkedListTraversal {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(5, 1, 3, 4, 7, 23, 78));

        Iterator it = list.descendingIterator();

        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
