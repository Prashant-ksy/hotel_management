package com.HotelAndRest.springProject.service;

import com.HotelAndRest.springProject.model.Employee;
import com.HotelAndRest.springProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Add a new employee
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Employee getEmployeeById(int empId) {
        return employeeRepository.findById(empId);
    }

    // Update employee
    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    // Delete employee by ID
    public void deleteEmployee(int empId) {
        employeeRepository.delete(empId);
    }
}
