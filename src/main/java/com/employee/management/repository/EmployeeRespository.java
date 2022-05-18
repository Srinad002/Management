package com.employee.management.repository;

import com.employee.management.model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);
}
