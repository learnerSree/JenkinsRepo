package com.dao;
import com.model.Employee;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.springframework.stereotype.Repository;
@Repository
public class NitriteDao {
	Nitrite db = Nitrite.builder().openOrCreate();
	ObjectRepository<Employee> employeeStore = db.getRepository(Employee.class);
	public ObjectRepository<Employee> getEmployeeStore() {
		return employeeStore;
	}
}
