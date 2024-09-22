package com.sravan.springboot.demo.service;

import java.util.List;

import com.sravan.springboot.demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee save(Employee employee);

	public Employee delete(int employeeId);
}
