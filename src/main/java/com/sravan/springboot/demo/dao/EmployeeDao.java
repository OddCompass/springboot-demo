package com.sravan.springboot.demo.dao;

import java.util.List;

import com.sravan.springboot.demo.entity.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();

	public Employee save(Employee employee);

	public Employee delete(int employeeId);

}
