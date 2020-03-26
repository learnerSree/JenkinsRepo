package com.dao;
import com.model.Employee;
import org.dizitart.no2.objects.Cursor;

import java.util.List;
public interface NitriteDao {
	public Cursor<Employee> getAllEmployees();
	public void addEmployee(Employee employee);
	public void addEmployees(List<Employee> employees);
	public void updateEmployee(Employee employee);
	public Cursor<Employee> getEmployeeById(int id);
	public void  removeById(int id);
}
