package com.pscode.simplerestapp.restapp.controller;

import com.pscode.simplerestapp.restapp.model.Employee;
import com.pscode.simplerestapp.restapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getAllEmployeeById(@PathVariable("id") Integer id) throws RuntimeException {
        return this.employeeService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee) {
        return this.employeeService.createEmployee(employee);
    }

    @PutMapping("update/{id}")
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        return this.employeeService.updatedEmployeeById(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        this.employeeService.deleteEmployeeById(id);
        return "Successfully deleted";
    }
}
