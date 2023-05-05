package com.pscode.simplerestapp.restapp.service;

import com.pscode.simplerestapp.restapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    Employee createEmployee(Employee employee);
    Employee updatedEmployeeById(Integer id, Employee employee);
    void deleteEmployeeById(Integer id);
}
