package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * The controller handles basic arithmetic operations:
 * 1. Addition
 * 2. Subtraction
 * 3. Multiplication
 * 4. Division
 */

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public Result add(@RequestParam double a, @RequestParam double b) {
        return new Result(a + b);
    }

    @GetMapping("/subtract")
    public Result subtract(@RequestParam double a, @RequestParam double b) {
        return new Result(a - b);
    }

    @GetMapping("/multiply")
    public Result multiply(@RequestParam double a, @RequestParam double b) {
        return new Result(a * b);
    }

    @GetMapping("/divide")
    public Result divide(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return new Result(a / b);
    }
}
