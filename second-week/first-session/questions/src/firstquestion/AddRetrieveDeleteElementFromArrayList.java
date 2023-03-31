package firstquestion;

import java.util.*;

public class AddRetrieveDeleteElementFromArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));


        System.out.println("Enter the operation that you want to perform on the ArrayList: ");
        System.out.println("1. Add Element");
        System.out.println("2. Retrieve Element on a given Index");
        System.out.println("3. Remove Element from a given index");
        System.out.println("4. Exit from loop");

        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        while(option != 4) {
            if(option == 1) {
                System.out.println("Enter element you want to add: ");
                int element = scanner.nextInt();
                System.out.println("Enter index where you want to add: ");
                int idx = scanner.nextInt();
                try {
                    System.out.println(addElement(list, element, idx));
                }
                catch (IndexOutOfBoundsException | InputMismatchException e) {
                    System.out.println("Exception is: " + e.getMessage());
                }

            }
            else if(option == 2) {
                System.out.println("Enter index you want to retrieve element from: ");
                int idx = scanner.nextInt();
                try{
                    System.out.println(list.get(idx-1));
                }
                catch (IndexOutOfBoundsException | InputMismatchException e) {
                    System.out.println("Exception is: " + e.getMessage());
                }

            }
            else if(option == 3) {
                System.out.println("Enter index from where you want to remove the element: ");
                int idx = scanner.nextInt();
                System.out.println("Array after removing from index - " + idx + ": ");
                try {
                    System.out.println(removeElement(list, idx));
                }
                catch (IndexOutOfBoundsException | InputMismatchException e) {
                    System.out.println("Exception is: " + e.getMessage());
                }
            }
            else {
                System.out.println("Please select the correct option");
            }
            System.out.println("Enter next operation to perform: ");
            option = scanner.nextInt();
        }
    }

    public static List<Integer> addElement(List<Integer> list, int element, int idx) {
        list.add(idx, element);
        return list;
    }
    public static List<Integer> removeElement(List<Integer> list, int idx) {
        list.remove(idx);
        return list;
    }
}