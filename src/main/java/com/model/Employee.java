
package com.model;
import org.dizitart.no2.objects.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//mongo database anootation
@Document(collection = "employee")
public class Employee {
	@Id
	private int id;
	private String name;
	private String designation;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", designation='" + designation + '\'' + '}';
	}
}
