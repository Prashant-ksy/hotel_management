package com.HotelAndRest.springProject.controller;

import com.HotelAndRest.springProject.model.Employee;
import com.HotelAndRest.springProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET: /employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // GET: /employees/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int empId) {
        Employee employee = employeeService.getEmployeeById(empId);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST: /employees
    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>("Employee added successfully.", HttpStatus.CREATED);
    }

    // PUT: /employees/{id}
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") int empId, @RequestBody Employee employee) {
        employee.setEmpId(empId);
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>("Employee updated successfully.", HttpStatus.OK);
    }

    // DELETE: /employees/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int empId) {
        employeeService.deleteEmployee(empId);
        return new ResponseEntity<>("Employee deleted successfully.", HttpStatus.OK);
    }
}
