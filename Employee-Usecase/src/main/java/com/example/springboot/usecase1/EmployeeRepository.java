package com.example.springboot.usecase1;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByRole(String role);
    Employee findById(long id);
}
