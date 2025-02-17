package com.example.springboot.usecase1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String role;

    protected Employee() {}

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("Employee[id=%d, name='%s', role='%s']", id, name, role);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}

