package com.employee.management.controller;

import com.employee.management.model.Employee;
import com.employee.management.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Adding new employee
    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/addAll")
    public List<Employee> addAllEmployees(List<Employee> employees){
        return employeeService.addAllEmployees(employees);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/{name}")
    public List<Employee> getEmployeesByName(@PathVariable String name){
        return  employeeService.getEmployeeByName(name);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id){
        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployeeById(@PathVariable int id){
         return employeeService.deleteEmployeeById(id);
    }
}
