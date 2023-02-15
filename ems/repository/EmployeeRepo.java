package com.ty.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ems.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
