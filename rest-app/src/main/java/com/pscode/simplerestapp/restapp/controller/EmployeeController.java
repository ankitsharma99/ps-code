package com.pscode.simplerestapp.restapp.controller;

import com.pscode.simplerestapp.restapp.model.Employee;
import com.pscode.simplerestapp.restapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
//    public List<Employee> getAllEmployees() {
//        return this.employeeService.getAllEmployees();
//    }
    public ResponseEntity<CollectionModel<EntityModel<Employee>>> getAllEmployees() {
        List<EntityModel<Employee>> employees = employeeService.getAllEmployees().stream()
                .map(employee -> EntityModel.of(employee,
                        Link.of(String.format("/api/employees/%d", employee.getId())).withSelfRel(),
                        Link.of(String.format("/api/employees/update/%d", employee.getId())).withRel("update employee"),
                        Link.of(String.format("/api/employees/%d", employee.getId())).withRel("delete employee")
                        ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(employees,
                Link.of("/api/employees/").withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Employee>> getAllEmployeeById(@PathVariable("id") Integer id) throws RuntimeException {
        Employee employee = this.employeeService.getEmployeeById(id);
//        employee.add()
        EntityModel<Employee> employeeModel = EntityModel.of(employee,
                Link.of(String.format("/api/employees/%d", id)).withSelfRel(),
                Link.of(String.format("/api/employees/update/%d", employee.getId())).withRel("update employee"),
                Link.of(String.format("/api/employees/%d", employee.getId())).withRel("delete employee")
        );

        return ResponseEntity.ok(employeeModel);
//        return this.employeeService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<EntityModel<Employee>> createEmployee(@RequestBody Employee employee) {
//        return this.employeeService.createEmployee(employee);
        Employee newEmployee = employeeService.createEmployee(employee);
        EntityModel<Employee> employeeModel = EntityModel.of(newEmployee,
                Link.of(String.format("/api/employees/%d", newEmployee.getId())).withSelfRel(),
                Link.of(String.format("/api/employees/update/%d", employee.getId())).withRel("update employee"),
                Link.of(String.format("/api/employees/%d", employee.getId())).withRel("delete employee")
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeModel);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<EntityModel<Employee>> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
//        return this.employeeService.updatedEmployeeById(id, employee);
        Employee updatedEmployee = employeeService.updatedEmployeeById(id, employee);
        EntityModel<Employee> employeeModel = EntityModel.of(updatedEmployee,
                Link.of(String.format("/api/employees/%d", id)).withSelfRel(),
                Link.of(String.format("/api/employees/%d", employee.getId())).withRel("delete employee"));

        return ResponseEntity.ok(employeeModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id) {
//        this.employeeService.deleteEmployeeById(id);
//        return "Successfully deleted";
        employeeService.deleteEmployeeById(id);

        return ResponseEntity.ok("Successfully deleted!");
    }
}
