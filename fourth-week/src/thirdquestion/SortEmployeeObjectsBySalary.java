package thirdquestion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee (int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
public class SortEmployeeObjectsBySalary {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Rahul", 50));
        employees.add(new Employee(2, "Rohit", 51));
        employees.add(new Employee(3, "Virat", 100));
        employees.add(new Employee(4, "Pant", 30));
        employees.add(new Employee(5, "Ashwin", 45));

        List<Employee> sorted = employees.stream().sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())).collect(Collectors.toList());

        System.out.println(sorted);
    }
}
