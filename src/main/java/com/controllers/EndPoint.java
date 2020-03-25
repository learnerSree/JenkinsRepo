package com.controllers;
import com.model.Employee;
import com.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
@RestController
public class EndPoint {
	@Autowired
	EmployeeService employeeService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@GetMapping("/hai/{name}")
	public String dummy(@PathVariable(value = "name") String name){
		return "Hai" + name;
	}
	@GetMapping(value = "/getall")
	public Collection<Employee> getAll(){
		logger.debug("Get all employees.");
		return employeeService.getAllEmployee();
	}
	@PostMapping(value = "/create")
	public String create(@RequestBody List<Employee> employees){
		logger.debug("Saving employees.");
		employeeService.createEmployee(employees);
		return "Employee created!";
	}

}
