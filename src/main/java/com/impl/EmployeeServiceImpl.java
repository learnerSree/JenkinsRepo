package com.impl;
import com.dao.EmployeeDao;
import com.model.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired EmployeeDao employeeDao;
	@Override public void createEmployee(List<Employee> employee) {
		employeeDao.saveAll(employee);
	}
	@Override public Collection<Employee> getAllEmployee() {
		return employeeDao.findAll();
	}
}
