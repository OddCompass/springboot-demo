package com.sravan.springboot.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sravan.springboot.demo.dao.EmployeeDao;
import com.sravan.springboot.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public Employee delete(int employeeId) {
		return employeeDao.delete(employeeId);
	}

}
