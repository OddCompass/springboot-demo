package com.sravan.springboot.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sravan.springboot.demo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;

	public EmployeeDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

	public Employee findById(Integer employeeId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		return employee;

	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		return entityManager.merge(employee);
	}

	@Override
	@Transactional
	public Employee delete(int employeeId) {
		Employee employee = findById(employeeId);
		entityManager.remove(employee);
		return employee;
	}

}
