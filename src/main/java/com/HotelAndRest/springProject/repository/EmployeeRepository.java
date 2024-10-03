package com.HotelAndRest.springProject.repository;

import com.HotelAndRest.springProject.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper for mapping database rows to Employee objects
    private static final RowMapper<Employee> employeeRowMapper = new RowMapper<Employee>() {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setEmpId(rs.getInt("Emp_ID"));
            employee.setName(rs.getString("Name"));
            employee.setPosition(rs.getString("Position"));
            employee.setHireDate(rs.getDate("HireDate"));
            employee.setSalary(rs.getDouble("Salary"));
            employee.setDob(rs.getDate("DOB"));
            employee.setHotelId(rs.getInt("Hotel_ID"));
            return employee;
        }
    };

    // Save a new employee
    public void save(Employee employee) {
        String query = "INSERT INTO Employee (Name, Position, HireDate, Salary, DOB, Hotel_ID) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query,
                employee.getName(),
                employee.getPosition(),
                employee.getHireDate(),
                employee.getSalary(),
                employee.getDob(),
                employee.getHotelId());
    }

    // Get all employees
    public List<Employee> findAll() {
        String query = "SELECT * FROM Employee";
        return jdbcTemplate.query(query, employeeRowMapper);
    }

    // Find an employee by ID
    public Employee findById(int empId) {
        String query = "SELECT * FROM Employee WHERE Emp_ID = ?";
        return jdbcTemplate.queryForObject(query, employeeRowMapper, empId);
    }

    // Update an employee
    public void update(Employee employee) {
        String query = "UPDATE Employee SET Name = ?, Position = ?, HireDate = ?, Salary = ?, DOB = ?, Hotel_ID = ? WHERE Emp_ID = ?";
        jdbcTemplate.update(query,
                employee.getName(),
                employee.getPosition(),
                employee.getHireDate(),
                employee.getSalary(),
                employee.getDob(),
                employee.getHotelId(),
                employee.getEmpId());
    }

    // Delete an employee by ID
    public void delete(int empId) {
        String query = "DELETE FROM Employee WHERE Emp_ID = ?";
        jdbcTemplate.update(query, empId);
    }
}
