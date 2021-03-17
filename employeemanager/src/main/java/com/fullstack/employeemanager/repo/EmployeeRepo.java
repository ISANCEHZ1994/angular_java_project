package com.fullstack.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fullstack.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    void deleteEmployeeById(Long id);

    Optional findEmployeeById(Long id); // what if the employee doesn't exist? hence we add optional
}
