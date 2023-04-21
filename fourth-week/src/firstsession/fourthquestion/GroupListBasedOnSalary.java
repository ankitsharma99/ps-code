package firstsession.fourthquestion;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
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

class GetSalary implements Function<Employee, Double> {
    public Double apply(Employee e) {
        return e.getSalary();
    }
}

class GetName implements Function<Employee, String> {
    public String apply(Employee e) {
        return e.getName();
    }
}

class PrintName implements Consumer<String> {
    public void accept(String name) {
        System.out.println(name);
    }
}
public class GroupListBasedOnSalary {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Rahul", 50));
        employees.add(new Employee(3, "Virat", 100));
        employees.add(new Employee(5, "Ashwin", 45));
        employees.add(new Employee(6, "Shardul", 45));
        employees.add(new Employee(7, "Rahane", 50));
        employees.add(new Employee(8, "Gaikwad", 100));

//        Map<Double, List<String>> employeeMap = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())));
//
//        System.out.println(employeeMap);

        employees.stream()
                .collect(Collectors
                        .groupingBy(new GetSalary(),
                                Collectors.mapping(new GetName(),
                                        Collectors.toList()
                                )
                        )
                )
                .forEach((salary, name) -> {
                    System.out.println(salary + ": ");
                    name.forEach(new PrintName());
                });
    }
}
