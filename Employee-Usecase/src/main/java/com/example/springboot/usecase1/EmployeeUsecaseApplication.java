package com.example.springboot.usecase1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeUsecaseApplication {

    private static final Logger log = LoggerFactory.getLogger(EmployeeUsecaseApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EmployeeUsecaseApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository repository) {
        return (args) -> {
            // Save a few employees
            repository.save(new Employee("Alice", "Developer"));
            repository.save(new Employee("Bob", "Tester"));
            repository.save(new Employee("Charlie", "Architect"));
            repository.save(new Employee("David", "Developer"));
            repository.save(new Employee("Emma", "Tester"));

            // Fetch all employees
            log.info("Employees found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(employee -> {
                log.info(employee.toString());
            });
            log.info("");

            // Fetch an individual employee by ID
            Employee employee = repository.findById(1L);
            log.info("Employee found with findById(1L):");
            log.info("--------------------------------");
            log.info(employee.toString());
            log.info("");

            // Fetch employees by role
            log.info("Employees found with findByRole('Developer'):");
            log.info("---------------------------------------------");
            repository.findByRole("Developer").forEach(dev -> {
                log.info(dev.toString());
            });
            log.info("");
        };
    }
}

