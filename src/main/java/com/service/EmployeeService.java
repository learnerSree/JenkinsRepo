package com.service;
import com.model.Employee;

import java.util.Collection;
import java.util.List;
public interface EmployeeService {
	public void createEmployee(List<Employee> employee);
	public Collection<Employee> getAllEmployee();
}
