package com.controllers;
import com.model.Employee;
import com.service.EmployeeService;
import org.dizitart.no2.objects.Cursor;
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
		logger.debug("=========================== Test end point ===========================");
		return "Hai" + name;
	}
	@GetMapping(value = "/getall")
	public Collection<Employee> getAll(){
		logger.debug("=========================== Get all employees - Mongo DB ===========================");
		return employeeService.getAllEmployee();
	}
	@PostMapping(value = "/create")
	public String create(@RequestBody List<Employee> employees){
		logger.debug("=========================== Saving employees - Mongo DB ===========================");
		employeeService.createEmployee(employees);
		return "Employee created!";
	}
	@GetMapping("/get/{name}")
	public Employee employeeByName(@PathVariable(value = "name") String name){
		logger.debug("=========================== Fetching by employee name - Mongo DB ===========================");
		return employeeService.findEmployeeByName(name);
	}
	@PostMapping(value = "/createSingle")
	public String createEmployee(@RequestBody Employee employee){
		try{
			employeeService.createSingleEmployee(employee);
		}catch (Exception e){
			logger.debug("********** Primary key violation! **********");
			return("Primary key violation");
		}

		logger.debug("=========================== Saving employees - Nitrite ===========================");
		return "Employee created!";
	}
	@GetMapping(value = "/allEmployees")
	public Cursor<Employee> getAllEmployeesByNitrite(){
		logger.debug("=========================== Fetching employees - Nitrite ===========================");
		return employeeService.getAllEmployeesByNitrite();
	}

	@PostMapping(value = "/createMulti")
	public String createEmployee(@RequestBody List<Employee> employee){
		try{
			employeeService.createMultiEmployees(employee);
		}catch (Exception e){
			logger.debug("********** Primary key violation! **********");
			return("Primary key violation");
		}
		logger.debug("=========================== Saving list of employees - Nitrite ===========================");
		return "Employees created!";
	}
	@PostMapping(value = "/update")
	public String updateEmployee(@RequestBody Employee employee){
		employeeService.updateEmployee(employee);
		logger.debug("=========================== Updating employee - Nitrite ===========================");
		return "Employee updated!";
	}
	@GetMapping(value = "/find/{id}")
	public Cursor<Employee> findById(@PathVariable(name = "id") int id){

		logger.debug("=========================== Fetch employees by Id - Nitrite ===========================");
		return employeeService.getEmployeeById(id);
	}
	@GetMapping(value = "/remove/{id}")
	public String removeById(@PathVariable(name = "id") int id){

		logger.debug("=========================== Fetch employees by Id - Nitrite ===========================");
		employeeService.removeEmployeeById(id);
		return "Employee deleted!";
	}
}
