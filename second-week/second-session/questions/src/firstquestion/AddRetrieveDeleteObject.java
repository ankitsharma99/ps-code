package firstquestion;

import java.util.ArrayList;
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
public class AddRetrieveDeleteObject {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Rohit", 23));
        list.add(new Person("Rahul", 25));
        list.add(new Person("Kohli", 22));
        list.add(new Person("Ashwin", 24));


        Person sky = new Person("Sky", 20);
        list.add(2, sky);
        System.out.println(list);

        list.remove(3);
        System.out.println(list);

        System.out.println(list.get(3));
    }
}
