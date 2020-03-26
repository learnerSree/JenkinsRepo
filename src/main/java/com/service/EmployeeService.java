package com.service;
import com.model.Employee;
import org.dizitart.no2.objects.Cursor;

import java.util.Collection;
import java.util.List;
public interface EmployeeService {
	public void createEmployee(List<Employee> employee);
	public Collection<Employee> getAllEmployee();
	public Employee findEmployeeByName(String name);
	public void createSingleEmployee(Employee employee);
	public Cursor<Employee>getAllEmployeesByNitrite();
	public void createMultiEmployees(List<Employee> employeees);
	public void updateEmployee(Employee employeee);
	public Cursor<Employee>getEmployeeById(int id);
	public void removeEmployeeById(int id);

}
