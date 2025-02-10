/**
 * 
 */
package com.example.demo;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
* The controller will ensure that the class will control how the object will be used
* it is done using 2 parts
* 	1. get mapping
*  2. request parameters
*/
@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	//AtomicLong is data type that will handle huge data
	private final AtomicLong atomicLong = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) { 		
		return new Greeting(atomicLong.incrementAndGet(), String.format(template, name)); 	
		}
}
