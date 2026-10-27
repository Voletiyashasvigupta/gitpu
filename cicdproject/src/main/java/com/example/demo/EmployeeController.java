package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final Map<Integer, String> employees = new HashMap<>();

    public EmployeeController() {
        employees.put(1, "Rahul");
        employees.put(2, "Priya");
    }

    // 1. GET - Retrieve all employees
    @GetMapping
    public Map<Integer, String> getAllEmployees() {
        return employees;
    }

    // 2. GET - Retrieve employee by ID
    @GetMapping("/{id}")
    public String getEmployeeById(@PathVariable int id) {
        return employees.getOrDefault(id, "Employee not found");
    }

    // 3. POST - Add a new employee
    @PostMapping("/{id}")
    public String addEmployee(
            @PathVariable int id,
            @RequestBody String name) {

        if (employees.containsKey(id)) {
            return "Employee ID already exists";
        }

        employees.put(id, name);
        return "Employee added successfully";
    }

    // 4. DELETE - Delete employee by ID
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        if (employees.remove(id) != null) {
            return "Employee deleted successfully";
        }

        return "Employee not found";
    }
}