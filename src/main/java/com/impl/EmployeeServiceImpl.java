package com.impl;
import com.dao.EmployeeDao;
import com.daoImpl.NitriteDaoImpl;
import com.model.Employee;
import com.service.EmployeeService;
import org.dizitart.no2.objects.Cursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired NitriteDaoImpl nDaoImpl;
	@Override
	public void createEmployee(List<Employee> employee) {
		employeeDao.saveAll(employee);

	}
	@Override
	public Collection<Employee> getAllEmployee() {
		return employeeDao.findAll();
	}
	@Override
	public Employee findEmployeeByName(String name) {
		return employeeDao.findByName(name);
	}
	@Override
	public void createSingleEmployee(Employee employee) {
		nDaoImpl.addEmployee(employee);
	}
	@Override
	public Cursor<Employee> getAllEmployeesByNitrite() {
		return nDaoImpl.getAllEmployees();
	}
	@Override
	public void createMultiEmployees(List<Employee> employeees) {
		nDaoImpl.addEmployees(employeees);
	}
	@Override
	public void updateEmployee(Employee employeee) {
		nDaoImpl.updateEmployee(employeee);
	}
	@Override
	public Cursor<Employee> getEmployeeById(int id) {
		return nDaoImpl.getEmployeeById(id);
	}
	@Override
	public void removeEmployeeById(int id) {
		nDaoImpl.removeById(id);
	}
}
