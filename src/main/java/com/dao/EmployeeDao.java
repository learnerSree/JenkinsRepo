package com.dao;
import com.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeDao extends MongoRepository<Employee, Integer> {
	Employee findByName(String name);
}
