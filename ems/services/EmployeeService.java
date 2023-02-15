package com.ty.ems.services;

import java.util.List;
import java.util.Optional;

import com.ty.ems.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);
	
	String updateEmployee(int eId);
	
	String deleteEmployee(int eId);
	
	List<Employee> getListOfEmployee();
	
	Optional<Employee> getEmployeeById(int eId);
	
}
