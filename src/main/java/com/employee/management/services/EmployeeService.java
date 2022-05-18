package com.employee.management.services;

import com.employee.management.model.Employee;
import com.employee.management.repository.EmployeeRespository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRespository employeeRespository;

    public Employee addEmployee(Employee employee) {
        return employeeRespository.save(employee);
    }

    public List<Employee> addAllEmployees(List<Employee> employees) {
        return employeeRespository.saveAll(employees);
    }

    public Employee getEmployeeById(int id) {
        return employeeRespository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Employee employee, int id) {
        Employee employee_entity = getEmployeeById(id);

        if(employee!=null){
            if (employee.getName() != null)
                employee_entity.setName(employee.getName());
            if (employee.getEmail() != null)
                employee_entity.setEmail(employee.getEmail());
            if (employee.getSalary() != 0)
                employee_entity.setSalary(employee.getSalary());
            if (employee.getAddress() != null)
                employee_entity.setAddress(employee.getAddress());
            if (employee.getPhoneNumber() != 0L)
                employee_entity.setPhoneNumber(employee.getPhoneNumber());
            if (employee.getDesignation() != null)
                employee_entity.setDesignation(employee.getDesignation());
            if (employee.getDepartment() != null)
                employee_entity.setDepartment(employee.getDepartment());
        }
        return employeeRespository.save(employee_entity);
    }

    public boolean deleteEmployeeById(int id) {
        Employee employee = getEmployeeById(id);
        if(employee!=null){
            employeeRespository.delete(employee);
            return true;
        }
        return false;
    }

    public List<Employee> getEmployeeByName(String name) {
        return employeeRespository.findByName(name);
    }
}
