package thirdquestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return this.name + " - " + this.age;
    }
}
public class SortArrayListWithObjects {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Rahul", 20));
        list.add(new Person("Virat", 19));
        list.add(new Person("Rohit", 16));
        list.add(new Person("Pant", 18));


//        Collections.sort(list, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.age-o2.age;
//            }
//        });
        list.sort(Comparator.comparingInt(o -> o.age));
        System.out.println(list);
    }
}
