package com.daoImpl;
import com.dao.NitriteDao;
import com.model.Employee;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class NitriteDaoImpl implements NitriteDao {
	// For file based DB -> un comment the below line and comment line no:16
	// Nitrite db = Nitrite.builder().filePath("tmp/test.db").autoCommitBufferSize(2048).openOrCreate();
	//For In memory DB
	Nitrite db = Nitrite.builder().openOrCreate();
	ObjectRepository<Employee> employeeStore = db.getRepository(Employee.class);
	@Override
	public Cursor<Employee> getAllEmployees() {
		return employeeStore.find();
	}
	@Override
	public void addEmployee(Employee employee) {
		employeeStore.insert(employee);

	}
	@Override
	public void addEmployees(List<Employee> employees) {
		Employee[] emp = employees.toArray(new Employee[0]);
		employeeStore.insert(emp);

	}
	@Override
	public void updateEmployee(Employee employee) {
		employeeStore.update(employee);

	}
	@Override public Cursor<Employee> getEmployeeById(int id) {
		return employeeStore.find(ObjectFilters.eq("id",id));
	}
	@Override public void removeById(int id) {
		employeeStore.remove(ObjectFilters.eq("id",id));
	}
}
