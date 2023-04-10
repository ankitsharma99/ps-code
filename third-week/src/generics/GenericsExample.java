package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {
        // type safety:
        List<Integer> list = new ArrayList<>();
        list.add(10);
//        list.add("10"); // error

        // no typecasting:
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        String str = stringList.get(0);
        System.out.println(str);


        // compile time checking:
        List<String> list1 = new ArrayList<>();
        list1.add("Hello");
//        list1.add(1); // error

        System.out.println(list1);

    }
}
