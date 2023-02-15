package com.ty.ems.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.ems.entity.Employee;
import com.ty.ems.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo empRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee emp = empRepo.save(employee);
		return emp;
	}

	@Override
	public String updateEmployee(int eId) {

		Optional<Employee> emp = empRepo.findById(eId);
		if(emp.isPresent())
		{
		Employee emp1 = new Employee();
		empRepo.save(emp1);
		return "Update Successfully";
		}
		else
		{
			return "Employee Not Found";
		}
		
	}

	@Override
	public String deleteEmployee(int eId) {
		empRepo.deleteById(eId);
		return "Data Deleted Successfully";
	}

	@Override
	public List<Employee> getListOfEmployee() {
		List<Employee> emp2 = empRepo.findAll();
		return emp2;
	}

	@Override
	public Optional<Employee> getEmployeeById(int eId) { 
		Optional<Employee> emp1 = empRepo.findById(eId);
		return emp1;
	}

}
