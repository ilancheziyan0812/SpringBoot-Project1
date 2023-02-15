package com.ty.ems.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.ems.entity.Employee;
import com.ty.ems.services.EmployeeService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService es;

	@GetMapping("/home")
	public String home()
	{
		return "Welcome to Employee Management System";
	}

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		Employee emp = es.addEmployee(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/remove/{eId}")
	public ResponseEntity<String> removeData(@PathVariable int eId)
	{
		es.deleteEmployee(eId);
		return new ResponseEntity<String>("Data Removed",HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/get/{eId}")
	public ResponseEntity<Optional<Employee>> getById(@PathVariable int eId)
	{
		Optional<Employee> emp = es.getEmployeeById(eId);
		return new ResponseEntity<Optional<Employee>> (emp , HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{eId}")
	public ResponseEntity<String> updateEmployee(@PathVariable int eId)
	{
		es.updateEmployee(eId);
		return new ResponseEntity<String>("update successfully",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAll()
	{
		List<Employee> emp = es.getListOfEmployee();
		return new  ResponseEntity<List<Employee>>(emp, HttpStatus.ACCEPTED);
		
	}

}
