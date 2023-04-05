package seventhquestion;

import java.util.*;

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

public class SortMapObjects {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        map.put(new Person("Rohit", 21), "Cricketer");
        map.put(new Person("Rahul", 22), "Footballer");
        map.put(new Person("Virat", 23), "Boxer");
        map.put(new Person("Pant", 19), "Racer");
        map.put(new Person("Gill", 24), "Cricketer");
        map.put(new Person("Ashwin", 27), "Boxer");


        List<Person> persons = new ArrayList<>(map.keySet());
        persons.sort(Comparator.comparingInt(o -> o.age));

        System.out.println(persons);

        LinkedHashMap<Person, String> sortedMap = new LinkedHashMap<>();
        for(Person person: persons) {
            sortedMap.put(person, map.get(person));
        }

        System.out.println("Sorted Map: ");
        for(Map.Entry<Person, String> e: sortedMap.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}
