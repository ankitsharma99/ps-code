package fifthquestion;

import java.util.LinkedList;
import java.util.Objects;

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
public class FirstAndLastObjectInLinkedList {

    public static void main(String[] args) {
        LinkedList<Person> list = new LinkedList<>();
        list.add(new Person("Rahul", 20));
        list.add(new Person("Virat", 19));
        list.add(new Person("Rohit", 16));
        list.add(new Person("Pant", 18));
        Person newPerson = new Person("SKY", 20);
        list.add(newPerson);
        list.add(new Person("Pant", 18));
        list.add(newPerson);

        System.out.println(list);
        // find first occurrence of newPerson:
        for(int i = 0; i<list.size(); i++) {
            if(list.get(i).equals(newPerson)) {
                System.out.println("First occurrence found at index: " + i);
                break;
            }
        }

        // find last Occurrence of newPerson:
        for(int i = list.size()-1; i>=0; i--) {
            if(list.get(i).equals(newPerson)) {
                System.out.println("First occurrence found at index: " + i);
                break;
            }
        }






    }
}
