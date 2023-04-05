package sixthquestion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }
}

public class CompareHashSetsWithObjects {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        set.add(new Person("Virat", 21));
//        Person p = new Person("Rohit", 23);
        set.add(new Person("Rahul", 22));
        set.add(new Person("Rohit", 23));
        set.add(new Person("Rohit", 23));
        set.add(new Person("Gill", 17));

        System.out.println(set);

        Set<Person> set1 = new HashSet<>();
        set.add(new Person("Virat", 21));
        set.add(new Person("Rahul", 22));
        set.add(new Person("Rohit", 23));
        set.add(new Person("Rohit", 23));
        set.add(new Person("Gill", 17));

        System.out.println(set.equals(set1));       // false

        set.clear();
        set1.clear();

        Person p = new Person("Rohit", 21);
        Person p2 = new Person("Virat", 22);
        Person p3 = new Person("Rahul", 23);

        set.addAll(Arrays.asList(p, p2, p3, p2, p2, p2));

        set1.addAll(Arrays.asList(p, p2, p3));

        System.out.println(set.equals(set1));

    }
}
