package com.pscode.simplerestapp.restapp.service.impl;

import com.pscode.simplerestapp.restapp.model.Employee;
import com.pscode.simplerestapp.restapp.repository.EmployeeRepository;
import com.pscode.simplerestapp.restapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = this.employeeRepository.findById(id);
        if(employee.isEmpty()) {
            throw new RuntimeException("No Employee Found");
        }
        return employee.get();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee updatedEmployeeById(Integer id, Employee employee) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);
        if(optionalEmployee.isEmpty()) {
            throw new RuntimeException("No Employee Found");
        }
        Employee updatedEmployee = optionalEmployee.get();
        updatedEmployee.setDepartment(employee.getDepartment());
        updatedEmployee.setSalary(employee.getSalary());
        updatedEmployee.setEmpName(employee.getEmpName());
        this.employeeRepository.save(updatedEmployee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        Optional<Employee> employee = this.employeeRepository.findById(id);
        if(employee.isEmpty()) {
            throw new RuntimeException("No Employee Found");
        }
        this.employeeRepository.deleteById(id);
    }
}
