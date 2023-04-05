package secondquestion;

import java.util.LinkedList;
import java.util.List;

public class LinkedListImplementation {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("Virat");        // adds at last
        linkedList.add("Rohit");        // adds at last
        linkedList.add("Rahul");
        System.out.println("Contents of LinkedList: " + linkedList);

        linkedList.add(3, "SKY");         // adds at specified index
        System.out.println("Contents of LinkedList: " + linkedList);

        linkedList.remove(3);
        System.out.println("Contents of LinkedList: " + linkedList);

        linkedList.addFirst("Bumrah");
        System.out.println("Contents of LinkedList: " + linkedList);

        linkedList.addLast("Shami");
        System.out.println("Contents of LinkedList: " + linkedList);

        System.out.println(linkedList.poll());
        System.out.println(linkedList.pollFirst());


    }
}
