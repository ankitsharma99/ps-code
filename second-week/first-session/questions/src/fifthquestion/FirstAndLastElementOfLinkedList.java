package fifthquestion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class FirstAndLastElementOfLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total numbers you want to enter: ");
        int n = sc.nextInt();

        System.out.println("Enter the numbers you want to have in your LinkedList: ");

        while(n > 0) {
            list.add(sc.nextInt());
            n--;
        }


        System.out.println("Enter the element you want to get the first and last occurence: ");
        int input = sc.nextInt();

        int firstIndex = list.indexOf(input);
        int lastIndex = list.lastIndexOf(input);
        if(firstIndex == -1 || lastIndex == -1) {
            System.out.println("Sorry the element is not present in the list");
        }
        else {
            System.out.println("First index is: " + firstIndex + ". Last index is: " + lastIndex);
        }

        sc.close();
    }
}
