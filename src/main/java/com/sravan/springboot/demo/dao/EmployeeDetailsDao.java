package com.sravan.springboot.demo.dao;

import java.util.List;
import java.util.Map;

import com.sravan.springboot.demo.dto.EmployeeDetailsResponse;
import com.sravan.springboot.demo.dto.PaginatedResponse;

public interface EmployeeDetailsDao {

	public List<EmployeeDetailsResponse> findAll();

	public PaginatedResponse searchByFilter(Map<String, String> queryParams);

}
