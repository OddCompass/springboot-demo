package com.sravan.springboot.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sravan.springboot.demo.dao.EmployeeDetailsDao;
import com.sravan.springboot.demo.dto.EmployeeDetailsResponse;
import com.sravan.springboot.demo.dto.PaginatedResponse;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	private EmployeeDetailsDao employeeDetailsDao;

	public EmployeeDetailsServiceImpl(EmployeeDetailsDao employeeDetailsDao) {
		super();
		this.employeeDetailsDao = employeeDetailsDao;
	}

	@Override
	public List<EmployeeDetailsResponse> findAll() {
		return employeeDetailsDao.findAll();
	}

	@Override
	public PaginatedResponse searchByFilter(Map<String, String> queryParams) {
		return employeeDetailsDao.searchByFilter(queryParams);
	}

}
