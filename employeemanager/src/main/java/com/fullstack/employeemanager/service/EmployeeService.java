package com.fullstack.employeemanager.service;

import com.fullstack.employeemanager.exception.UserNotFoundException;
import com.fullstack.employeemanager.model.Employee;
import com.fullstack.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo; // here we are using the interface

    @Autowired
    public EmployeeService(EmployeeRepo er) {
        employeeRepo = er;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) throws Throwable {
        return employeeRepo
                .findEmployeeById(id)// from EmployeeRepo Interface
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
                // NOTE: UserNotFoundException has to be created!
    }

    public void deleteEmployee( Long id){
        employeeRepo.deleteEmployeeById(id); // we have to create our own method to do what we want it to
        // getting method from EmployeeRepo Interface
    }


}

